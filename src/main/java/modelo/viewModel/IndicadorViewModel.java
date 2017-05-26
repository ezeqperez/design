package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;

public class IndicadorViewModel {
    private Indicador indicador;

    public IndicadorViewModel() {
        indicador = new Indicador();
    }

    public String getNombre() {
        return indicador.getNombre();
    }

    public String getFormula() {
        return indicador.getFormula();
    }

    public void setFormula(String formula) {
        indicador.setFormula(formula);
    }

    public void setNombre(String nombre) {
        indicador.setNombre(nombre);
    }
}
