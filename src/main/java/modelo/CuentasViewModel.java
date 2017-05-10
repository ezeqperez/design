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
    public CuentasViewModel(CuentasUploader cuentasUploader) {
        this.cuentasUploader = cuentasUploader;
        this.cuentas = new ArrayList<Cuenta>();
        this.cuentasFiltradas = new ArrayList<Cuenta>();
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    private String ruta;  //Ruta donde se va a buscar el archivo a procesar

    private CuentasUploader cuentasUploader; // Dependencia

    private List<Cuenta> cuentas; // Total de cuentas procesadas
    private List<Cuenta> cuentasFiltradas; // Cuentas que cumplen el filtro de empresa y de periodo
    private String empresaFilter;

    private String periodoFilter;
    public void cargarCuentas() throws org.json.simple.parser.ParseException {
        cuentas.addAll(cuentasUploader.procesarArchivo(ruta));
    }


    public void filtrarCuentas() {
        try {
            Objects.requireNonNull(this.periodoFilter);
            Objects.requireNonNull(this.empresaFilter);
            cuentasFiltradas = cuentas.stream()
                    .filter(cuenta -> Objects.equals(cuenta.getPeriodo(), this.periodoFilter)
                            && Objects.equals(cuenta.getEmpresa(), this.empresaFilter))
                    .collect(Collectors.toList());

        } catch (NullPointerException e) {
            throw new UserException("Los valores periodo y empresa no pueden estar vacios");
        }
    }

    // Getters y setters
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public CuentasUploader getCuentasUploader() {
        return cuentasUploader;
    }

    public void setCuentasUploader(CuentasUploader cuentasUploader) {
        this.cuentasUploader = cuentasUploader;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuentas(Cuenta cuenta) {
        this.cuentas.add(cuenta);
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
