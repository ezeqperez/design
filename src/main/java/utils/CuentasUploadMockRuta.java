package utils;


import modelo.Cuenta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.uqbar.commons.model.UserException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentasUploadMockRuta implements CuentasUploader {
    List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
    Object obj;
    String jsonMalo;

    public List<Cuenta> procesarArchivo() {
        List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
        JSONParser parser = new JSONParser();
        JsonParser jsonParser = new JsonParser();
        try {
            obj = parser.parse(jsonMalo);
        }catch(org.json.simple.parser.ParseException e){
            throw new UserException("Json mal formateado");
        }


        JSONArray jsonArray = (JSONArray) obj;

        jsonArray.forEach(item -> {
            JSONObject json = (JSONObject) item;
            listaDeCuentas.add(jsonParser.jsonACuenta(json));
        });

        return listaDeCuentas;
   }

    public String getRuta() {
        return "ruta";
    }

    public void setRuta(String ruta) {

    }

    public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }


    public String getJsonMalo() {
        return jsonMalo;
    }

    public void setJsonMalo(String jsonMalo) {
        this.jsonMalo = jsonMalo;
    }
}
