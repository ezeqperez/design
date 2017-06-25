package modelo.dominio;

import modelo.dominio.operandos.Bodoque;
import modelo.repositorios.EmpresasRepository;
import utils.Indicadores.IndicadorAplicado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Indicador {

	private String nombre;
	private Bodoque bodoque;
	private List<IndicadorAplicado> listaIndicadores;
	private IndicadorAplicado indicadorAplicado = new IndicadorAplicado();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Bodoque getBodoque() {
		return bodoque;
	}

	public void setBodoque(Bodoque bodoque) {
		this.bodoque = bodoque;
	}

	public List<IndicadorAplicado> existeEnPeriodo(List<Empresa> repoEmpresa) {
		listaIndicadores = new ArrayList<>();

		EmpresasRepository.getInstance().getEmpresas().forEach(itemEmpresa -> {
			itemEmpresa.getPeriodos().forEach(itemPeriodo -> {
				if (itemPeriodo.existenCuentas(bodoque.getPrimerOperando(), bodoque.getSegundoOperando())) {
					indicadorAplicado = new IndicadorAplicado();
					// Debería ir un constructor si existe
					String nombreEmpresa = itemEmpresa.getNombre();
					BigDecimal valor = bodoque.valor(itemPeriodo);
					indicadorAplicado.setAnioPeriodo(itemPeriodo.getPeriodo());
					indicadorAplicado.setNombreEmpresa(nombreEmpresa);
					indicadorAplicado.setNombreIndicador(this.getNombre());
					indicadorAplicado.setExiste(true);
					indicadorAplicado.setValor(valor);

					// System.out.println("Indicador a agregar en lista
					// "+indicadorAplicado.getNombreIndicador());
					listaIndicadores.add(indicadorAplicado);

				} else {
					// Debería ir un constructor si no existe para guardar los indicadores que no se aplican
					// indicadorAplicado.setAnioPeriodo(itemPeriodo.getPeriodo());
					// indicadorAplicado.setNombreEmpresa(itemEmpresa.getNombre());
					// indicadorAplicado.setNombreIndicador(this.getNombre());
					// indicadorAplicado.setExiste(false);

				}
			});
		});

		return listaIndicadores;
	}

	public void agregarIndicadorAplicado(IndicadorAplicado in) {
		listaIndicadores.add(in);
	}

}
