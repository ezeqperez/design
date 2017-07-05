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

    public void agregarEmpresas(List<Metodologia> empresasAAgregar) {
        metodologias.addAll(empresasAAgregar);
    }

    public void insert(Metodologia metodologia){
        metodologias.add(metodologia);
    }

    public void delete(Metodologia metodologia) {
        metodologias.remove(metodologia);
    }

    public List<Metodologia> getEmpresas() {
        return metodologias;
    }

    public void setEmpresas(List<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

}
