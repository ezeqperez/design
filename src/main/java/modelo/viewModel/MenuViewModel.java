package modelo.viewModel;

import modelo.dominio.Cuenta;
import modelo.dominio.Empresa;
import org.uqbar.commons.utils.Observable;
import utils.IJSONUploader;
import utils.JSONUpload;
import java.util.ArrayList;
import java.util.List;

@Observable
public class MenuViewModel {
    private IJSONUploader iJsonUploader; // Dependencia
    private List<Empresa> empresas = new ArrayList<>();
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public MenuViewModel(IJSONUploader iJsonUploader) {
        this.iJsonUploader = iJsonUploader;
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public List<Cuenta> cargarCuentas() throws org.json.simple.parser.ParseException {
        JSONUpload jsonUpload = new JSONUpload();
        setCuentas(jsonUpload.procesarArchivo(ruta));
        return getCuentas();
    }

    public List<Cuenta> getCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        for (Empresa empresa:empresas) {
            cuentas.addAll(empresa.getCuentas());
        }
        return cuentas;
    }

    private void setCuentas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
