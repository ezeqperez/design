package utils.Empresas;

import com.google.gson.Gson;
import modelo.dominio.Empresa;
import org.json.simple.JSONObject;

public class JsonParser {

    Empresa jsonAEmpresa(JSONObject json) {
            Gson gson = new Gson();
            return gson.fromJson(json.toString(), Empresa.class);
    }

}
