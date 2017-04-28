package utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import modelo.Cuenta;
import modelo.Empresa;

public class JsonParser {
    //Transforma una cuenta en un string
    public String parsearCuenta(Cuenta cuenta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cuenta);
    }

    //TODO: Y si se arma uno generico que reciba una clase por parametro?
    public  Cuenta jsonACuenta(org.json.JSONObject json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Cuenta.class);
        }catch (IOException e){
            System.out.println("Se rompio");
        }
        return null;
    }
    
    public  Empresa jsonAEmpresa(String json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Empresa.class);
        }catch (IOException e){
            System.out.println("Se rompio");
        }
        return null;
    }


}
