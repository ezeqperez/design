import org.junit.Test;
import org.uqbar.commons.model.UserException;
import utils.CuentasUpload;
import utils.CuentasUploadMockRuta;

import java.io.FileNotFoundException;

public class CuentasUploadTest {

	Fixture fixture = new Fixture();
	@Test(expected = UserException.class)
	public void noEncuentraElArchivo(){
		CuentasUpload cuentasUpload = new CuentasUpload();
		cuentasUpload.setRuta("C:/rompe.json");
		cuentasUpload.procesarArchivo();
	}

	@Test(expected = UserException.class)
	public void jsonMalFormateado(){
		//TODO: ver de cargar el string
		CuentasUploadMockRuta cuentasUpload = new CuentasUploadMockRuta();
		cuentasUpload.setJsonMalo(fixture.jsonMalo());
		cuentasUpload.procesarArchivo();
	}

}
