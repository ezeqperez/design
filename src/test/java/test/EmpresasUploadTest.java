package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.uqbar.commons.model.UserException;

import modelo.dominio.Empresa;
import modelo.repositorios.EmpresasRepository;
import utils.Empresas.EmpresasUpload;
import utils.Excepciones.ExcepcionParseo;

public class EmpresasUploadTest {
    
	EmpresasUpload empresasUpload;
	
    @Rule
    public ExpectedException expecterEx = ExpectedException.none();

    @Before
    public void iniciar(){
    	empresasUpload = new EmpresasUpload();
    }

    @Test
    public void noEncuentraElArchivo() {
        expecterEx.expect(UserException.class);
        expecterEx.expectMessage("No se encontro el archivo");
        empresasUpload.procesarArchivo("src/test/resources/rompe.json");
    }

    @Test
    public void cargaJsonVacio() {
        expecterEx.expect(ExcepcionParseo.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");        
        empresasUpload.procesarArchivo("src/test/resources/jsonVacio.json");
    }

    @Test
    public void cargaDeJsonMalArmado() {
        expecterEx.expect(ExcepcionParseo.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        empresasUpload.procesarArchivo("src/test/resources/jsonMalArmado.json");
    }

    @Test
    public void cargaJsonCorrupto() {
        expecterEx.expect(ExcepcionParseo.class);
        expecterEx.expectMessage("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        empresasUpload.procesarArchivo("src/test/resources/jsonCorrupto.json");
    }

    @Test
    public void cargaDosEmpresas() {
        EmpresasRepository.getInstance().agregarEmpresas(empresasUpload.procesarArchivo("src/test/resources/test.json"));
        Assert.assertEquals(EmpresasRepository.getInstance().getEmpresas().size(), 2);
    }
}