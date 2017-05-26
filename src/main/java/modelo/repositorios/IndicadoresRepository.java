package modelo.repositorios;

import modelo.dominio.Indicador;
import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.List;

@Observable
public class IndicadoresRepository{
    private List<Indicador> indicadores;

    private static IndicadoresRepository ourInstance = new IndicadoresRepository();

    public static IndicadoresRepository getInstance() {
        return ourInstance;
    }

    public IndicadoresRepository() {
        indicadores = new ArrayList<>();
    }

    public void insert(Indicador indicador){
        indicadores.add(indicador);
    }

    public Indicador search(String name) {
        return indicadores.stream().filter(indicador -> indicador.getNombre() == name).findFirst().orElse(null);
    }

    public void update(Indicador indicador) {
        delete(search(indicador.getNombre()));
        insert(indicador);
    }

    public void delete(Indicador indicador) {
        indicadores.remove(indicador);
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

}

