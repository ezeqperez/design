import modelo.Cuenta;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.uqbar.commons.model.UserException;
import utils.CuentasUpload;

import java.util.List;

public class CuentasUploadTest {
    Fixture fixture = new Fixture();

    @Rule
    public ExpectedException expecterEx = ExpectedException.none();

    @Test
    public void noEncuentraElArchivo() {
        expecterEx.expect(UserException.class);
        expecterEx.expectMessage("No se encontro el archivo");
        CuentasUpload cuentasUpload = new CuentasUpload();
        cuentasUpload.setRuta("C://rompe.json");
        cuentasUpload.procesarArchivo();
    }

    @Test
    public void cargaJsonVacio() {
        expecterEx.expect(UserException.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        CuentasUpload cuentasUpload = new CuentasUpload();
        cuentasUpload.setRuta("C:\\Users\\Ezequiel\\Intellij\\Tp1\\src\\main\\resources\\jsonVacio.json");
        cuentasUpload.procesarArchivo();
    }

    @Test
    public void cargaDeJsonMalArmado() {
        expecterEx.expect(UserException.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        CuentasUpload cuentasUpload = new CuentasUpload();
        cuentasUpload.setRuta("C:\\Users\\Ezequiel\\Intellij\\Tp1\\src\\main\\resources\\jsonNoArray.json");
        cuentasUpload.procesarArchivo();
    }

    @Test
    public void cargaJsonCorrupto() {
        expecterEx.expect(UserException.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        CuentasUpload cuentasUpload = new CuentasUpload();
        cuentasUpload.setRuta("C:\\Users\\Ezequiel\\Intellij\\Tp1\\src\\main\\resources\\jsonMalo.json");
        cuentasUpload.procesarArchivo();
    }

    @Test
    public void cargaTresEmpresas() {
        CuentasUpload cuentasUpload = new CuentasUpload();
        cuentasUpload.setRuta("C:\\Users\\Ezequiel\\Intellij\\Tp1\\src\\main\\resources\\jsonOk.json");
        List<Cuenta> cuentasCargadas = cuentasUpload.procesarArchivo();
        Assert.assertEquals(cuentasCargadas.size(), 8);
    }
}
