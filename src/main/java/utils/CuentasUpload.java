package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import modelo.Cuenta;

public class CuentasUpload {
	private String ruta = "C:\\test.json";

	// TODO: Manejar la excepcion, si la arrojo se me quejaba alguien (ahora no
	// recuerdo)
	public List<Cuenta> procesarArchivo() throws org.json.simple.parser.ParseException {
		List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
		// El parser es quien se encarga de cargar el archivo desde la ruta
		// especificada
		JSONParser parser = new JSONParser();

		// El jsonParser va ser quien se encarga de transformar el json cargado
		// a una cuenta,
		// que va a ser devuelta al viewModel
		 JsonParser jsonParser = new JsonParser();

		// TODO: Ver como hacerlo mas lindo / con mas sentido

		try {

			Object obj = parser.parse(new FileReader(ruta));

			// Creo un array porque mi archivo tiene una lista de cuentas a
			// cargar
			JSONArray jsonArray = (JSONArray) obj;

			// TODO: Armar algo como if(!jsonArray.isEmpty()){}, para controlar
			// que no recorramos una lista vacia
			jsonArray.forEach(item -> {
				JSONObject json = (JSONObject) item;
				listaDeCuentas.add(jsonParser.jsonACuenta(json));
			});
		} catch (IOException e) {
			// TODO: aca queremos avisarle al usuario que se carg� mal y que lo
			// debe
			// volver a intentar.
		}
		return listaDeCuentas;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}