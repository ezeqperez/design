package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;
import java.util.List;

public class SearchIndicadoresViewModel {
    private IndicadoresRepository indicadoresRepository;
    private Indicador indicador;

    public List<Indicador> getIndicadores() {
        return indicadoresRepository.getIndicadores();
    }

    public void setIndicadores(List<Indicador> indicadores) {
        indicadoresRepository.setIndicadores(indicadores);
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getFormula() {
        return indicador.getFormula();
    }
}
