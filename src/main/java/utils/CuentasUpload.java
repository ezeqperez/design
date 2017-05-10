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

public class CuentasUpload implements CuentasUploader {

    public List<Cuenta> procesarArchivo(String ruta) {
        List<Cuenta> cuentas = new ArrayList<Cuenta>();
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
            jsonArray.forEach(item -> {
                JSONObject json = (JSONObject) item;
                cuentas.add(jsonParser.jsonACuenta(json));
            });
        } catch (IOException e) {
            throw new UserException("No se encontro el archivo");
        } catch (org.json.simple.parser.ParseException e) {
            throw new UserException("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        }
        return cuentas;
    }

}