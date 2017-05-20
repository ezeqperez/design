package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.repositorio.EmpresasRepository;
import org.uqbar.commons.utils.Observable;
import utils.IJSONUploader;
import java.util.ArrayList;

@Observable
public class EmpresasViewModel {
    // Esta clase procesa las empresas que se cargan desde el archivo.
    private IJSONUploader jsonUploader; // Dependencia
    private EmpresasRepository repoEmpresas = new EmpresasRepository();
    //private List<Cuenta> cuentasFiltradas; // Cuentas que cumplen el filtro de empresa y de periodo
    private String empresaFilter;
    private int periodoFilter;

    public EmpresasViewModel(IJSONUploader empresasUploader) {
        this.jsonUploader = empresasUploader;
        //this.empresas = new ArrayList<Empresa>();
        //this.cuentasFiltradas = new ArrayList<Cuenta>();
    }

    public void filtrarEmpresas() {
        repoEmpresas.filtrarEmpresas(empresaFilter);
    }

    // Getters y setters
    public void setEmpresaFilter(String empresaFilter) {
        this.empresaFilter = empresaFilter;
    }

    public int getPeriodoFilter() {
        return periodoFilter;
    }

    public void setPeriodoFilter(int periodoFilter) {
        this.periodoFilter = periodoFilter;
    }

}