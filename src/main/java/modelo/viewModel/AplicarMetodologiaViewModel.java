package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.dominio.Metodologia;
import org.uqbar.commons.utils.Observable;
import vista.MetodologiasMock.MetodologiasMock;

import java.util.ArrayList;
import java.util.List;

@Observable
public class AplicarMetodologiaViewModel {

    private List<Empresa> empresas;
    private Metodologia metodologia;
    private List<Metodologia> metodologias;
    private List<Empresa> empresasFiltradas;

    public AplicarMetodologiaViewModel() {
        empresas = MetodologiasMock.getEmpresas();//EmpresasRepository.getInstance().getEmpresas();
        metodologia = new Metodologia();
        metodologia.setNombre("Hola");
        empresasFiltradas = new ArrayList<>();
        metodologias = MetodologiasMock.getMetodologias(); //MetodologiasRepository.getInstance().getMetodologias();
    }

    public void aplicarMetodologia(){
        setEmpresasFiltradas(getMetodologia().aplicar(empresas));
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public List<Metodologia> getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(List<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

    public List<Empresa> getEmpresasFiltradas() {
        return empresasFiltradas;
    }

    public void setEmpresasFiltradas(List<Empresa> empresasFiltradas) {
        this.empresasFiltradas = empresasFiltradas;
    }
}
