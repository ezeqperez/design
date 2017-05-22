package utils.Empresas;

import modelo.dominio.Empresa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.uqbar.commons.model.UserException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpresasUpload implements EmpresasUploader {

    public List<Empresa> procesarArchivo(String ruta) {
        List<Empresa> empresas = new ArrayList<>();
        JSONParser parser = new JSONParser();
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
        } catch (ParseException e) {
            throw new UserException("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        }
        return empresas;
    }
}