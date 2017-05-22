package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.repositorio.EmpresasRepository;
import org.json.simple.parser.ParseException;
import org.uqbar.commons.utils.Observable;
import utils.Empresas.EmpresasUploader;
import utils.Empresas.EmpresasUpload;
import utils.Indicadores.IndicadoresUpload;

import java.util.ArrayList;
import java.util.List;

@Observable
public class MenuViewModel {
    private EmpresasRepository repoEmpresas = new EmpresasRepository();
    private EmpresasUploader empresasUploader; // Dependencia
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar
    private String rutaIndicadores;

    public MenuViewModel(EmpresasUploader iJsonEmpresasUploader) {
        this.empresasUploader = iJsonEmpresasUploader;
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public void cargarEmpresas() throws ParseException {
        final EmpresasUpload empresasUpload = new EmpresasUpload();
        repoEmpresas.agregarEmpresas(empresasUpload.procesarArchivo(ruta));
    }

    public void cargarIndicadores() throws ParseException {
        final IndicadoresUpload indicadoresUpload = new IndicadoresUpload();
        indicadoresUpload.cargarIndicadores(rutaIndicadores);
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
