package utils.Indicadores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import modelo.dominio.*;

public class EscribirObjeto {

	public void serializarIndicador(Indicador indicador) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream("src/test/resources/test.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(indicador);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}}
	}

