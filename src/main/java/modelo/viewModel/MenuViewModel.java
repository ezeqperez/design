package modelo.viewModel;

import modelo.dominio.Cuenta;
import modelo.dominio.Empresa;
import modelo.repositorio.EmpresasRepository;
import org.uqbar.commons.utils.Observable;
import utils.IJSONUploader;
import utils.JSONUpload;
import java.util.ArrayList;
import java.util.List;

@Observable
public class MenuViewModel {
    private EmpresasRepository repoEmpresas = new EmpresasRepository();
    private IJSONUploader iJsonUploader; // Dependencia
    private List<Empresa> empresas = new ArrayList<>();
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar

    public MenuViewModel(IJSONUploader iJsonUploader) {
        this.iJsonUploader = iJsonUploader;
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public List<Empresa> cargarEmpresas() throws org.json.simple.parser.ParseException {
        JSONUpload jsonUpload = new JSONUpload();
        setEmpresas(jsonUpload.procesarArchivo(ruta));
        repoEmpresas.agregarEmpresas(getEmpresas());
        return getEmpresas();
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
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

    public IJSONUploader getiJsonUploader() {
        return iJsonUploader;
    }

    public void setiJsonUploader(IJSONUploader iJsonUploader) {
        this.iJsonUploader = iJsonUploader;
    }
}
