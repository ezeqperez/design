package test.tp2;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.uqbar.commons.model.UserException;

import modelo.dominio.Indicador;
import utils.Indicadores.EscribirObjeto;


public class TestFile {
	
	@Test
    public void noEncuentraElArchivo() {

		EscribirObjeto obj = new EscribirObjeto();

		Indicador indicador = new Indicador();
		indicador.setNombre("wall street");
		obj.serializarIndicador(indicador);
    }


}
