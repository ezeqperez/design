package modelo;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import utils.CuentasUploader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class CuentasViewModel {
	// Esta clase procesa las cuentas que se cargan desde el archivo.
	public CuentasViewModel(CuentasUploader cuentasUploader){
		this.cuentasUploader= cuentasUploader;
		this.listaDeCuentas= new ArrayList<Cuenta>();
		this.cuentasFiltradas = new ArrayList<Cuenta>();
	}

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



	public void cargarCuentas() throws org.json.simple.parser.ParseException{
		listaDeCuentas.addAll(cuentasUploader.procesarArchivo());
	}

	public void filtrarCuentas() {
		try {
			Objects.requireNonNull(this.periodoFilter);
			Objects.requireNonNull(this.empresaFilter);
		}catch (NullPointerException e){
			throw new UserException("Los valores periodo y empresa no pueden estar vacios");
		}
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
