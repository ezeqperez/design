package utils;

import modelo.Empresa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.uqbar.commons.model.UserException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUpload implements IJSONUploader {

    public List<Empresa> procesarArchivo(String ruta) {
        List<Empresa> empresas = new ArrayList<Empresa>();
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
                empresas.add(jsonParser.jsonAEmpresa(json));
            });
        } catch (IOException e) {
            throw new UserException("No se encontro el archivo");
        } catch (org.json.simple.parser.ParseException e) {
            throw new UserException("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        }
        return empresas;
    }

}