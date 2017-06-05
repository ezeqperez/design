package modelo.repositorios;

import modelo.dominio.Indicador;
import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Observable
public class IndicadoresRepository{
	
    private List<Indicador> indicadores;

    private static IndicadoresRepository ourInstance;

    public static IndicadoresRepository getInstance() {
        if (ourInstance == null) {
            ourInstance = new IndicadoresRepository();
        }
        return ourInstance;
    }

    private IndicadoresRepository() {
        indicadores = new ArrayList<>();
    }

    public void insert(Indicador indicador){
        indicadores.add(indicador);
    }

    public Indicador search(String name) {
        return indicadores.stream().filter(indicador -> indicador.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
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

    public List<String> getIndicadoresPorNombre() {
        return indicadores.stream().map(Indicador::getNombre).collect(Collectors.toList());
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

}

