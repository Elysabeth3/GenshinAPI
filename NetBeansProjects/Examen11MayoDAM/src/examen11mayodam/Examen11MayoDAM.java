package examen11mayodam;

import java.util.Iterator;
import java.util.Set;

public class Examen11MayoDAM {

    public static String alumnoNeaeNotas(String cadena, Alumnado alumnado) {
        Iterator<NotaAlumnado> it2 = NotaAlumnado.notasAlumnado(alumnado.getNie());
        if (it2 != null) {
            int contador = 0;
            while (it2.hasNext()) {
                contador++;
                NotaAlumnado nota = it2.next();
                if (contador == 1) {
                    cadena += alumnado.getNombre() + " Nota: " + nota.getValor() + "\n";
                }
            }
        }
        return cadena;
    }

    public static Alumnado crearAlumnado() {
        String nombre = EntradaTeclado.pedirCadena("Introduce el nombre del alumno: ");
        String opcion = EntradaTeclado.pedirCadena("¿El alumno tiene NEAE?");
        if ("Si".equalsIgnoreCase(opcion)) {
            double coeficiente = EntradaTeclado.pedirDouble("Introduce el coeficiente de correccion: [1.0 - 2.0]");
            return new AlumnoadoNEAE(coeficiente, nombre);
        }
        return new Alumnado(nombre);
    }

    public static NotaAlumnado crearNota() {
        String fecha = EntradaTeclado.pedirCadena("Introduce la fecha de la nota: ");
        double valor = EntradaTeclado.pedirDouble("Introduce la nota que ha sacado");
        return new NotaAlumnado(fecha, valor);
    }

    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Introducir alumnado");
            System.out.println("2. Eliminar alumnado");
            System.out.println("3. Introducir nota de alumno/a");
            System.out.println("4. Mostrar información (sin notas) de todos los alumnos del grupo");
            System.out.println("5. Mostrar todas las notas de un alumno");
            System.out.println("6. Mostrar el nombre de todos los alumnos NEAE con alguna nota");
            System.out.println("0. Salir");
            opcion = EntradaTeclado.pedirEntero("Introduzca una opcion: ");
        } while ((opcion < 0) || (opcion > 6));

        return opcion;
    }

    public static void main(String[] args) {
        GrupoAlumnado g1 = new GrupoAlumnado();

        int opcion = 0;

        do {
            opcion = menu();

            switch (opcion) {
                case 1 -> {
                    Alumnado alumnado = crearAlumnado();
                    if (g1.inscribirAlumnado(alumnado)) {
                        System.out.println("Alumno introducido con exito");
                    } else {
                        System.out.println("No se ha podido introducir al alumno");
                    }
                }
                case 2 -> {
                    Integer nie = EntradaTeclado.pedirEntero("Introduce el NIE del alumno a eliminar: ");
                    Alumnado alumnado = g1.encontrarPorNie(nie);
                    if (alumnado != null) {
                        if (g1.eliminarAlumnado(alumnado)) {
                            NotaAlumnado.eliminarNotas(nie);
                            System.out.println("El alumno y sus notas se han eliminado correctamente.");
                        }
                    } else {
                        System.out.println("No se ha podido encontrar al alumno");
                    }
                }
                case 3 -> {
                    Integer nie = EntradaTeclado.pedirEntero("Introduce el NIE del alumno: ");
                    Alumnado alumnado = g1.encontrarPorNie(nie);
                    NotaAlumnado nota = crearNota();
                    if (alumnado instanceof AlumnoadoNEAE) {
                        nota.setValor(((AlumnoadoNEAE) alumnado).calculoNota(nota.getValor()));
                    }
                    g1.insertarNotaAlumnado(nie, nota);
                }
                case 4 -> {
                    System.out.println(g1.toString());
                }
                case 5 -> {
                    Integer nie = EntradaTeclado.pedirEntero("Introduce el NIE del alumno: ");
                    String cadena = "";
                    Iterator<NotaAlumnado> it = NotaAlumnado.notasAlumnado(nie);
                    if (it != null) {
                        while (it.hasNext()) {
                            NotaAlumnado next = it.next();
                            cadena += next.getValor() + "\n";
                        }
                        System.out.println(cadena);
                    } else {
                        System.out.println("No se ha encontrado notas del alumno");
                    }
                }
                case 6 -> {
                    Set<Integer> conjuntoNie = NotaAlumnado.codigosAlumnado();
                    Alumnado alumnado;
                    String cadena = "";
                    Iterator<Integer> it = conjuntoNie.iterator();

                    while (it.hasNext()) {
                        Integer nie = it.next();
                        alumnado = g1.encontrarPorNie(nie);
                        if (alumnado instanceof AlumnoadoNEAE) {
                            cadena = alumnoNeaeNotas(cadena, alumnado);
                        }
                    }
                    System.out.println(cadena);
                }

            }

        } while (opcion != 0);

    }

}
