package modelo.viewModel;

import modelo.dominio.Indicador;
import modelo.repositorios.EmpresasRepository;
import modelo.repositorios.IndicadoresRepository;
import utils.Indicadores.IndicadorAplicado;

import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

/*
    Revisar completo
 */

@Observable
public class SearchIndicadoresViewModel {

	private EmpresasRepository repoEmpresas;
	private IndicadoresRepository repoIndicadores;

	private List<IndicadorAplicado> indicadoresAplicados = new ArrayList<IndicadorAplicado>();

	public SearchIndicadoresViewModel(IndicadoresRepository repoIn, EmpresasRepository repoEmpresa) {
		repoEmpresas = repoEmpresa;
		repoIndicadores = repoIn;
	}

	public List<IndicadorAplicado> getIndicadoresAplicados() {
		return indicadoresAplicados;
	}

	public void setIndicadoresAplicados(List<IndicadorAplicado> indicadoresAplicados) {
		this.indicadoresAplicados = indicadoresAplicados;
	}

	public List<Indicador> getIndicadores() {
		return IndicadoresRepository.getInstance().getIndicadores();
	}

	public void setIndicadores(List<Indicador> indicadores) {
		IndicadoresRepository.getInstance().setIndicadores(new ArrayList<Indicador>());
	}

	public List<String> getIndicadoresPorNombre() {
		return IndicadoresRepository.getInstance().getIndicadoresPorNombre();
	}

	public void setIndicadoresPorNombre(List<String> indicadores) {
		IndicadoresRepository.getInstance().setIndicadores(new ArrayList<Indicador>());
	}

	public void cargadIndicadores() {
		/*
		IndicadoresRepository.getInstance().getIndicadores().forEach(itemIndicador -> {
			if (itemIndicador.existeEnPeriodo(repoEmpresas.getEmpresas())) {
				indicadoresAplicados.addAll(itemIndicador.getListaIndicadores());
			}
			;
		});
		*/
	}

}
