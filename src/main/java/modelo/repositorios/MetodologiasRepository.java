package modelo.repositorios;

import modelo.dominio.Metodologia;
import java.util.ArrayList;
import java.util.List;

public class MetodologiasRepository {

    private List<Metodologia> metodologias = new ArrayList<>();
    private static MetodologiasRepository ourInstance = null;

    private MetodologiasRepository() {
        metodologias = new ArrayList<>();
    }

    public static MetodologiasRepository getInstance() {
        if (ourInstance == null){
            ourInstance = new MetodologiasRepository();
        }
        return ourInstance;
    }

    public void vaciar(){
        metodologias = new ArrayList<>();
    }

    public void agregarMetodologias(List<Metodologia> metodologiasNuevas) {
        metodologias.addAll(metodologiasNuevas);
    }

    public void insert(Metodologia metodologia){
        metodologias.add(metodologia);
    }

    public void delete(Metodologia metodologia) {
        metodologias.remove(metodologia);
    }

    public List<Metodologia> getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(List<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

}
