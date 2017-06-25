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

	private List<IndicadorAplicado> indicadoresAplicados = new ArrayList<>();
	private List<IndicadorAplicado> indicadoresNoAplicados = new ArrayList<IndicadorAplicado>();
	private IndicadorAplicado indicador = new IndicadorAplicado();

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

		
		IndicadoresRepository.getInstance().getIndicadores().forEach(itemIndicador -> {
			indicadoresAplicados.addAll(itemIndicador.existeEnPeriodo(EmpresasRepository.getInstance().getEmpresas()));

//			if (indicador.getExiste()) {
//				System.out.println("indicador que se va a agregar SI existe: " + indicador.getNombreEmpresa());
//				indicadoresAplicados.add(indicador);
//			} else {
//				System.out.println("indicador que se va a agregar si NO existe: " + indicador.getNombreEmpresa());
//
//				indicadoresNoAplicados.add(indicador);
//			}

		});

	}

}
