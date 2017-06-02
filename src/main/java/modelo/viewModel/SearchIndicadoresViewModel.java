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

	// private List<Indicador> indicadores;
	// private List<String> indicadoresPorNombre;
	// private Indicador indicador;
	// private String nombreIndicador;
	// private String formula;
	private EmpresasRepository repoEmpresas;
	private IndicadoresRepository repoIndicadores;

	private List<IndicadorAplicado> indicadoresAplicados = new ArrayList<IndicadorAplicado>();

	public SearchIndicadoresViewModel(IndicadoresRepository repoIn, EmpresasRepository repoEmpresa) {
		this.repoEmpresas = repoEmpresa;
		this.repoIndicadores = repoIn;
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

		IndicadoresRepository.getInstance().getIndicadores().forEach(itemIndicador -> {
			if (itemIndicador.existeEnPeriodo(repoEmpresas.getEmpresas())) {
				indicadoresAplicados.addAll(itemIndicador.getListaIndicadores());
			}
			;
		});

	}

	// public Indicador getIndicador() {
	// return indicador;
	// }
	//
	// public void setIndicador(Indicador indicador) {
	// this.indicador = indicador;
	// this.formula = indicador.getFormula();
	// }
	//
	// public String getFormula() {
	// return formula;
	// }
	//
	// public void setFormula(String formula) {
	// this.formula = formula;
	// }
	//
	// public String getNombreIndicador() {
	// return nombreIndicador;
	// }
	//
	// public void setNombreIndicador(String nombreIndicador) {
	// this.nombreIndicador = nombreIndicador;
	// this.indicador =
	// IndicadoresRepository.getInstance().search(nombreIndicador);
	// this.formula = indicador.getFormula();
	// }

}
