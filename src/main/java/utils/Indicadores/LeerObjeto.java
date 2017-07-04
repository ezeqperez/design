package utils.Indicadores;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import modelo.dominio.Indicador;

public class LeerObjeto {
	
	public Indicador deserializarObjeto(String ruta){
		
		Indicador indicador = null;

		try (ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream(ruta))) {

			indicador = (Indicador) ois.readObject();

		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		return indicador;
	}

}
