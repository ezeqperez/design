package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;
import java.util.List;

public class SearchIndicadoresViewModel {
    IndicadoresRepository indicadoresRepository;

    public List<Indicador> getIndicadores() {
        return indicadoresRepository.getIndicadores();
    }

    public void setIndicadores(List<Indicador> indicadores) {
        indicadoresRepository.setIndicadores(indicadores);
    }
}
