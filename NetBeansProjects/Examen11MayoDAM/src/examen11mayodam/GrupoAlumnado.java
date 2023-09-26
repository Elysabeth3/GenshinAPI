package examen11mayodam;

import java.util.*;


public class GrupoAlumnado {
    private List<Alumnado> grupoAlumnado;

    public GrupoAlumnado() {
        grupoAlumnado = new ArrayList<>();
    }
    
    public boolean inscribirAlumnado(Alumnado alumnado){
        if (!grupoAlumnado.contains(alumnado)) {
            return grupoAlumnado.add(alumnado);
        }
        return false;
    }
    
    public boolean eliminarAlumnado(Alumnado alumnado){
        return grupoAlumnado.remove(alumnado);
    }
    
    public Alumnado encontrarPorNie(Integer nie){
        for (int i = 0; i < grupoAlumnado.size(); i++) {
            Alumnado get = grupoAlumnado.get(i);
            if (get.getNie()==nie) {
                return get;
            }
        }
        return null;
    }
    
    public boolean insertarNotaAlumnado(Integer nie, NotaAlumnado nota){
        Alumnado alumnado = encontrarPorNie(nie);
        if (alumnado != null) {
            NotaAlumnado.introducirNota(nie, nota);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return grupoAlumnado.toString();
    }
    
    
}
