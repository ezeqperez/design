package modelo.viewModel;

import modelo.repositorios.EmpresasRepository;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.utils.Observable;
import utils.Empresas.EmpresasUploader;
import utils.Empresas.EmpresasUpload;

@Observable
public class MenuViewModel {
    private EmpresasRepository repoEmpresas = null;
    private EmpresasUploader empresasUploader; // Dependencia
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar
    private final IndicadoresRepository repoIndicadores;

    public MenuViewModel(EmpresasUploader iJsonEmpresasUploader) {
        empresasUploader = iJsonEmpresasUploader;
        ruta = "src/test/resources/test.json"; //Comienza con una ruta por defecto
        repoIndicadores = IndicadoresRepository.getInstance();
    }

    public void cargarEmpresas(){
        final EmpresasUpload empresasUpload = new EmpresasUpload();
        EmpresasRepository.getInstance().agregarEmpresas(empresasUpload.procesarArchivo(ruta));
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public EmpresasRepository getRepoEmpresas() {
        return repoEmpresas;
    }

    public void setRepoEmpresas(EmpresasRepository repoEmpresas) {
        this.repoEmpresas = repoEmpresas;
    }

    public EmpresasUploader getEmpresasUploader() {
        return empresasUploader;
    }

    public void setEmpresasUploader(EmpresasUploader iJsonEmpresasUploader) {
        empresasUploader = iJsonEmpresasUploader;
    }

    public IndicadoresRepository getRepoIndicadores(){
    	return repoIndicadores;
    }

}
