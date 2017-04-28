package utils;


import modelo.Cuenta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentasUploadMockRuta implements CuentasUploader {
    List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
    Object obj;

    public List<Cuenta> procesarArchivo(){
        List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
        JSONParser parser = new JSONParser();
        JsonParser jsonParser = new JsonParser();


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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }
}
