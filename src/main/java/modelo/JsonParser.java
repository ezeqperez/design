package modelo;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.IOException;

public class JsonParser {
    //Transforma una cuenta en un string
    public String parsearCuenta(Cuenta cuenta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cuenta);
    }

    //TODO: Y si se arma uno generico que reciba una clase por parametro?
    public  Cuenta jsonACuenta(JSONObject json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Cuenta.class);
        }catch (IOException e){
            System.out.println("Se rompio");
        }
        return null;
    }


}
