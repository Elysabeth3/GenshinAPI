package examen11mayodam;

import java.util.*;

public class NotaAlumnado {
    private String fecha;
    private double valor;
    
    private static Map<Integer,Set<NotaAlumnado>> notasAlumnado;
    
    static {
        notasAlumnado = new HashMap<>();
    }

    public NotaAlumnado(String fecha, double valor) {
        this.fecha = fecha;
        this.valor = valor;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public void setValor(double valor) {
        this.valor = valor;
    }
 
    public double getValor() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotaAlumnado other = (NotaAlumnado) obj;
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        String cadena = "La nota es: " + this.valor + " se obtuvo en la fecha " + this.fecha;
        return cadena;
    }
    
    
    public static boolean introducirNota(Integer nie, NotaAlumnado n){
        if(notasAlumnado.containsKey(nie)){
           Set<NotaAlumnado> notasAlumno = notasAlumnado.get(nie);
           notasAlumno.add(n);
           notasAlumnado.put(nie, notasAlumno);
           return true;
        } else {
           Set<NotaAlumnado> notasAlumno = new HashSet<>(); 
           notasAlumno.add(n);
           notasAlumnado.put(nie, notasAlumno);
           return true;
        }
    }
    
    public static boolean eliminarNotas(Integer nie){
        if(notasAlumnado.containsKey(nie)){
            Set<NotaAlumnado> notasAlumno = notasAlumnado.get(nie);
            notasAlumno.clear();
            notasAlumnado.put(nie, notasAlumno);
            return true;
        }
        return false;
    }
    
    public static Set<Integer> codigosAlumnado(){
        Set<Integer> codigosAlumnado = new HashSet<>();
        for ( Integer nie : notasAlumnado.keySet() ) {
            codigosAlumnado.add(nie);
        }
        return codigosAlumnado;
    }
    
    public static Iterator<NotaAlumnado> notasAlumnado(Integer nie){
        if (notasAlumnado.containsKey(nie)) {
            Set<NotaAlumnado> notasAlumno = notasAlumnado.get(nie); 
            return notasAlumno.iterator();
        }
        return null;
    } 
}
