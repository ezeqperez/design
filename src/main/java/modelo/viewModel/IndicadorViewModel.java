package modelo.viewModel;

import modelo.dominio.Indicador;
import org.uqbar.commons.utils.Observable;
import utils.parser.IndicadorParser;

@Observable
public class IndicadorViewModel {
    private Indicador indicador;
    private String nombre = null;
    private String formula = null;

    public IndicadorViewModel() {
        indicador = new Indicador();
    }

    public void guardarIndicador(){
        final IndicadorParser parser = new IndicadorParser();
        parser.generarIndicador(nombre, formula);
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
