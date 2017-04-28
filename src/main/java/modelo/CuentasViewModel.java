package modelo;

import org.uqbar.commons.utils.Observable;

import utils.CuentasUpload;
import vista.ErrorWindow;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class CuentasViewModel {
	// Esta clase procesa las cuentas que se cargan desde el archivo.

	private CuentasUpload cuentasUpload; // Dependencia
	private List<Cuenta> listaDeCuentas; // Total de cuentas procesadas
	private List<Cuenta> cuentasFiltradas = listaDeCuentas; // Cuentas que
															// cumplen el filtro
															// de empresa y
															// periodo
	// TODO: Las cuentas filtradas son las que se tienen que mostrar en una
	// vista nueva

	private String empresaFilter;
	private String periodoFilter;

	// TODO: Ver como manejar las excepciones, si las arrojo, se me queja la
	// vista

	public void cargarCuentas() {
		try {
			listaDeCuentas.addAll(cuentasUpload.procesarArchivo());
		} catch (Exception e) {
			// TODO: Mostrar error al cargar archivo.
		}
	}

	public void filtrarCuentas() {
		// TODO: Sacar el if, Gaston se va a enojar
		if (this.validarEmpresaYCuenta()) {
			cuentasFiltradas = listaDeCuentas.stream()
					.filter(cuenta -> Objects.equals(cuenta.getPeriodo(), this.periodoFilter)
							&& Objects.equals(cuenta.getEmpresa(), this.empresaFilter))
					.collect(Collectors.toList());
			System.out.println("asd");
		} else {
			// TODO: algun cartel que diga que estos campos no pueden estar
			// vacios?
		}
	}

	private boolean validarEmpresaYCuenta() {
		// TODO: Feo feo, la idea es tirar una excepcion si esto no se cumple, y
		// no hacer el if guarango de arriba
		// PERO NO SE COMO!!!!
		return !this.empresaFilter.isEmpty() && !this.periodoFilter.isEmpty();
	}

	// Getters y setters
	public CuentasUpload getCuentasUpload() {
		return cuentasUpload;
	}

	public void setCuentasUpload(CuentasUpload cuentasUpload) {
		this.cuentasUpload = cuentasUpload;
	}

	public List<Cuenta> getListaDeCuentas() {
		return listaDeCuentas;
	}

	public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
		this.listaDeCuentas = listaDeCuentas;
	}

	public String getEmpresaFilter() {
		return empresaFilter;
	}

	public void setEmpresaFilter(String empresaFilter) {
		this.empresaFilter = empresaFilter;
	}

	public String getPeriodoFilter() {
		return periodoFilter;
	}

	public void setPeriodoFilter(String periodoFilter) {
		this.periodoFilter = periodoFilter;
	}

	public List<Cuenta> getCuentasFiltradas() {
		return cuentasFiltradas;
	}

	public void setCuentasFiltradas(List<Cuenta> cuentasFiltradas) {
		this.cuentasFiltradas = cuentasFiltradas;
	}

}
