package utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import modelo.Cuenta;
import org.json.simple.JSONObject;

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
