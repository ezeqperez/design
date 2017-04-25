package modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CuentasUpload {

    //dejo este para no romper nada
    public Empresa procesarArchivo() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("C:\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            return new JsonParser().jsonAEmpresa(jsonObject);

        } catch (Exception e) {
            System.out.println("eeee");
        }
        return null;
    }

    public List<Cuenta> procesarArchivoCuenta() {
        JSONParser parser = new JSONParser();
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = parser.parse(new FileReader("C:\\cuentas.json"));

            JSONArray jsonArray= (JSONArray) obj;
            List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();

            jsonArray.forEach(item -> {
                JSONObject json = (JSONObject) item;
                listaDeCuentas.add(jsonParser.jsonACuenta(json));
            });
        return listaDeCuentas;

        } catch (Exception e) {
            System.out.println("eeee");
        }
        return null;
    }
}