package test.tp2;


import modelo.dominio.Indicador;
import org.junit.Assert;
import org.junit.Test;
import utils.Indicadores.EscribirObjeto;
//import utils.Indicadores.LeerObjeto;


public class TestFile {
	
	@Test
    public void GuardarIndicador() {

		EscribirObjeto obj = new EscribirObjeto();

		Indicador indicador = new Indicador();
		indicador.setNombre("indicador1");
		obj.serializarIndicador(indicador);
    }
	
	@Test
    public void LeerIndicador() {

/*
		LeerObjeto obj = new LeerObjeto();

		Indicador indicador = obj.deserializarObjeto("src/test/resources/test.txt");
		Assert.assertTrue(indicador.getNombre().equals("indicador1"));
*/
    }


}
