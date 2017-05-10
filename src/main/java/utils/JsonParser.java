package utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import modelo.Cuenta;
import org.json.simple.JSONObject;
import org.uqbar.commons.model.UserException;

public class JsonParser {
    //Transforma una cuenta en un string
    public String parsearCuenta(Cuenta cuenta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cuenta);
    }

    public Cuenta jsonACuenta(JSONObject json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Cuenta.class);
        } catch (IOException e) {
            throw new UserException("El formato del json esta corrupto, reemplaze el archivo e intente nuevamente");
        }
    }

}
