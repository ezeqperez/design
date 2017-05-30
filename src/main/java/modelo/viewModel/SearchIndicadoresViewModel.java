package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

/*
    Revisar completo
 */


@Observable
public class SearchIndicadoresViewModel {
    private IndicadoresRepository indicadoresRepository;
    private List<Indicador> indicadores;
    private Indicador indicador;
    private String formula;

    public List<Indicador> getIndicadores() {
        return IndicadoresRepository.getInstance().getIndicadores();
    }

    public void setIndicadores(List<Indicador> indicadores) {
        IndicadoresRepository.getInstance().setIndicadores(new ArrayList<Indicador>());
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
