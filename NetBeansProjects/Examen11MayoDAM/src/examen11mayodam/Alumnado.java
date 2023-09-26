package examen11mayodam;

public class Alumnado {
    private static int niePosible;
    private int nie;
    private String nombre;
    
    static {
        niePosible = 1;
    }

    public Alumnado(String nombre) {
        this.nie = niePosible++;
        this.nombre = nombre;
    }

    public int getNie() {
        return nie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.nie;
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
        final Alumnado other = (Alumnado) obj;
        return this.nie == other.nie;
    }

    @Override
    public String toString() {
        String cadena = "-- " + this.getClass().getSimpleName() + " --\n";
        cadena += "NIE: " + this.nie + "\n";
        cadena += "Nombre: " + this.nombre + "\n";
        return cadena;
    }
    
    
    
    
}
