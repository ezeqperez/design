package utils.Indicadores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import modelo.dominio.*;

public class EscribirObjeto {

	public void serializarIndicador(Indicador indicador) {

		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("src/test/resources/test.txt"))) {

			oos.writeObject(indicador);

		} catch (Exception ex) {
			ex.printStackTrace();
		}}
	}

