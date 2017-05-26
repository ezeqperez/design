package modelo.viewModel;

import modelo.dominio.Cuenta;
import modelo.repositorios.EmpresasRepository;
import org.uqbar.commons.utils.Observable;

import java.util.List;

@Observable
public class EmpresasViewModel {
    private EmpresasRepository repoEmpresas;
    private String empresaFilter;
    private int periodoFilter;
    private List<Cuenta> cuentasFiltradas;

    public EmpresasViewModel(EmpresasRepository repoEmpresas) {
        this.repoEmpresas = repoEmpresas;
    }

    public void filtrarCuentas() {
        setCuentasFiltradas(repoEmpresas.filtrarEmpresas(empresaFilter).getPeriodo(periodoFilter).getCuentas());
    }

    public List<Cuenta> getCuentasFiltradas() {
        return cuentasFiltradas;
    }

    public void setCuentasFiltradas(List<Cuenta> cuentasFiltradas) {
        this.cuentasFiltradas = cuentasFiltradas;
    }

    public String getEmpresaFilter() {
        return empresaFilter;
    }

    public void setEmpresaFilter(String empresaFilter) {
        this.empresaFilter = empresaFilter;
    }

    public int getPeriodoFilter() {
        return periodoFilter;
    }

    public void setPeriodoFilter(int periodoFilter) {
        this.periodoFilter = periodoFilter;
    }

    public EmpresasRepository getRepoEmpresas() {
        return repoEmpresas;

    }

    public void setRepoEmpresas(EmpresasRepository repoEmpresas) {
        this.repoEmpresas = repoEmpresas;
    }

}