package modelo;

import org.uqbar.commons.utils.Observable;
import utils.CuentasUpload;
import utils.CuentasUploader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julieta on 18/05/2017.
 */
@Observable
public class MenuViewModel {
    private CuentasUploader cuentasUploader; // Dependencia
    private List<Cuenta> cuentas; // Total de cuentas procesadas
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public MenuViewModel(CuentasUploader cuentasUploader) {
        this.cuentasUploader = cuentasUploader;
        this.cuentas = new ArrayList<>();
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public List<Cuenta> cargarCuentas() throws org.json.simple.parser.ParseException {
        CuentasUpload cuentasUpload = new CuentasUpload();
        setCuentas(cuentasUpload.procesarArchivo(ruta));
        return getCuentas();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
