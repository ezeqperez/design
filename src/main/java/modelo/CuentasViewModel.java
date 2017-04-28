package modelo;

import org.uqbar.commons.utils.Observable;

import utils.CuentasUploader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class CuentasViewModel {
	// Esta clase procesa las cuentas que se cargan desde el archivo.
	public CuentasViewModel(CuentasUploader cuentasUploader, List<Cuenta> listaDeCuentas){
		this.cuentasUploader= cuentasUploader;
		this.listaDeCuentas= listaDeCuentas;
		this.cuentasFiltradas = new ArrayList<Cuenta>();
	}

	private CuentasUploader cuentasUploader; // Dependencia
	private List<Cuenta> listaDeCuentas; // Total de cuentas procesadas
	private List<Cuenta> cuentasFiltradas; // Cuentas que
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
			listaDeCuentas.addAll(cuentasUploader.procesarArchivo());
		} catch (Exception e) {
			// TODO: Mostrar error al cargar archivo.
		}
	}

	public void filtrarCuentas() {
		//Esto va encerrado en un try/catch para manejar la excepcion
		//Por ahora prefiero que la tire para el test
		Objects.requireNonNull(this.periodoFilter);
		Objects.requireNonNull(this.empresaFilter);
		cuentasFiltradas = listaDeCuentas.stream()
				.filter(cuenta -> Objects.equals(cuenta.getPeriodo(), this.periodoFilter)
						&& Objects.equals(cuenta.getEmpresa(), this.empresaFilter))
				.collect(Collectors.toList());
	}


	// Getters y setters
	public CuentasUploader getCuentasUploader() {
		return cuentasUploader;
	}

	public void setCuentasUploader(CuentasUploader cuentasUploader) {
		this.cuentasUploader = cuentasUploader;
	}

	public List<Cuenta> getListaDeCuentas() {
		return listaDeCuentas;
	}

	public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
		this.listaDeCuentas = listaDeCuentas;
	}

    public void addListaDeCuentas(Cuenta cuenta) {
        this.listaDeCuentas.add(cuenta);
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
