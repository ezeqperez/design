package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.utils.Observable;
import utils.parser.IndicadorParser;

@Observable
public class IndicadorViewModel {
    private Indicador indicador;
    private String nombre;
    private String formula; //La formula a analizar

    public IndicadorViewModel() {
        indicador = new Indicador();
    }

    public void guardarIndicador(){
        IndicadorParser parser = new IndicadorParser();
        IndicadoresRepository.getInstance().insert(parser.generarIndicador(nombre, formula));
    }


    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
