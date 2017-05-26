package modelo.viewModel;

import modelo.repositorios.EmpresasRepository;
import org.uqbar.commons.utils.Observable;
import utils.Empresas.EmpresasUploader;
import utils.Excepciones.ExcepcionParseo;
import utils.Empresas.EmpresasUpload;

@Observable
public class MenuViewModel {
    private EmpresasRepository repoEmpresas = new EmpresasRepository();
    private EmpresasUploader empresasUploader; // Dependencia
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar

    public MenuViewModel(EmpresasUploader iJsonEmpresasUploader) {
        empresasUploader = iJsonEmpresasUploader;
        ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public void cargarEmpresas(){
    		final EmpresasUpload empresasUpload = new EmpresasUpload();
    		repoEmpresas.agregarEmpresas(empresasUpload.procesarArchivo(ruta));
    		throw new ExcepcionParseo("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
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

}
