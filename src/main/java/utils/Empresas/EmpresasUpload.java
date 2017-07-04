package utils.Empresas;

import modelo.dominio.Empresa;
import utils.Excepciones.*;
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
        final List<Empresa> empresas = new ArrayList<>();
        final JSONParser parser = new JSONParser();
        final JsonParser jsonParser = new JsonParser();
        final Object obj;
        try {
            obj = parser.parse(new FileReader(ruta));
            final JSONArray jsonArray = (JSONArray) obj;
            jsonArray.forEach(item -> {
                final JSONObject json = (JSONObject) item;
                empresas.add(jsonParser.jsonAEmpresa(json));
            });
        } catch (final IOException e) {
            throw new UserException("No se encontro el archivo");
        } catch (final ParseException e) {
            throw new ExcepcionParseo("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
        }
        return empresas;
    }
}