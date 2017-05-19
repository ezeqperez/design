package modelo;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class CuentasViewModel {
    // Esta clase procesa las cuentas que se cargan desde el archivo.
    public CuentasViewModel(List<Cuenta> cuentasList) {
        this.cuentas = cuentasList;
        this.cuentasFiltradas = new ArrayList<>();
    }

    private List<Cuenta> cuentas; // Total de cuentas procesadas
    private List<Cuenta> cuentasFiltradas; // Cuentas que cumplen el filtro de empresa y de periodo
    private String empresaFilter;
    private String periodoFilter;

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
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
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
