package utils;

import java.io.IOException;
import modelo.dominio.Empresa;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.uqbar.commons.model.UserException;

public class JsonParser {
    public String parsearEmpresa(Empresa empresa) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(empresa);
    }

    Empresa jsonAEmpresa(JSONObject json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            //En esta línea falla.
            return mapper.readValue(json.toString(), Empresa.class);
        } catch (IOException e) {
            throw new UserException("El formato del json esta corrupto, reemplaze el archivo e intente nuevamente");
        }
    }

}
