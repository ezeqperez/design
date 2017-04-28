package utils;

import modelo.Cuenta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.uqbar.commons.model.UserException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuentasUpload implements CuentasUploader{
	private String ruta = "C:\\test.json";

	public List<Cuenta> procesarArchivo(){
		List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
		// El parser es quien se encarga de cargar el archivo desde la ruta
		// especificada
		JSONParser parser = new JSONParser();

		// El jsonParser va ser quien se encarga de transformar el json cargado
		// a una cuenta,
		// que va a ser devuelta al viewModel
		 JsonParser jsonParser = new JsonParser();

		Object obj;
		try {
			obj = parser.parse(new FileReader(ruta));
			JSONArray jsonArray = (JSONArray) obj;
			Objects.requireNonNull(jsonArray);
			jsonArray.forEach(item -> {
				JSONObject json = (JSONObject) item;
				listaDeCuentas.add(jsonParser.jsonACuenta(json));
			});
		}catch (IOException e) {
			throw new UserException("No se encontró el archivo");
		}catch (org.json.simple.parser.ParseException e) {
			throw new UserException("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
		}catch (NullPointerException e){
			throw new UserException("El archivo estaba vacio");
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