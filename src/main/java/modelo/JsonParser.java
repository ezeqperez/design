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

    //Transforma un json en una cuenta
    public Empresa construirEmpresa(String json){
        try {
            ObjectMapper mapper = new ObjectMapper();

            //Para que ignore el error del string generado cabeza
            mapper.configure(
                    DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            return mapper.readValue(json, Empresa.class);
        }catch (IOException e){
            //No me importa, hay que corregirlo
        }
        return null;
    }

    public  Empresa jsonAEmpresa(JSONObject json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Empresa.class);
        }catch (IOException e){
            System.out.println("Se rompio");
        }
        return null;
    }
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
