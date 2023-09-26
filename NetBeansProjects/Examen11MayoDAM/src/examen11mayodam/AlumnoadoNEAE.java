package examen11mayodam;

public class AlumnoadoNEAE extends Alumnado implements Calculable {
    private double coeficienteCorreccion;

    public AlumnoadoNEAE(double coeficienteCorreccion, String nombre) {
        super(nombre);
        if(coeficienteCorreccion <= 2.0 && coeficienteCorreccion >= 1.0)
            this.coeficienteCorreccion = coeficienteCorreccion;
        else
            this.coeficienteCorreccion = 1.0;
    }

    public double getCoeficienteCorreccion() {
        return coeficienteCorreccion;
    }

    public void setCoeficienteCorreccion(double coeficienteCorreccion) {
        if(coeficienteCorreccion <= 2.0 && coeficienteCorreccion >= 1.0)
            this.coeficienteCorreccion = coeficienteCorreccion;
    }

    @Override
    public double calculoNota(double notaInicial) {
        return notaInicial * coeficienteCorreccion;
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "Coeficiente de correccion: " + this.coeficienteCorreccion + "\n";
        return cadena;
    }

}
