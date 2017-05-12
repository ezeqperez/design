import modelo.Cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezequiel on 24/4/2017.
 */
public class Fixture {
    public String jsonNoArray() {
        String json = "{\n" +
                "\"empresa\" : \"Juan\",\n" +
                "\"cuenta\": \"100005454\",\n" +
                "\"periodo\": \"2017\",\n" +
                "\"monto\": 123456789\n" +
                "},\n" +
                "{\n" +
                "\"empresa\" : \"Juan\",\n" +
                "\"cuenta\": \"200005454\",\n" +
                "\"periodo\": \"2016\",\n" +
                "\"monto\": 156789.64\n" +
                "},\n" +
                "{\n" +
                "\"empresa\" : \"Eze\",\n" +
                "\"cuenta\": \"500005454\",\n" +
                "\"periodo\": \"2016\",\n" +
                "\"monto\": 50009456789\n" +
                "}";
        return json;
    }

    public String jsonMalo() {
        String json = "{\n" +
                "\"empresa\" : \"Juan\",\n" +
                "\"cuenta\": \"100005454\",\n" +
                "\"periodo\": \"2017\",\n" +
                "\"monto\": 123456789\n" +
                "\"empresa\" : \"Eze\",\n" +
                "},\n" +
                "},\n" +
                "},\n" +
                "\"cuenta\": \"500005454\",\n" +
                "\"periodo\": \"2016\",\n" +
                "\"monto\": 50009456789\n" +
                "}";
        return json;
    }

    public String jsonOk() {
        String json = "[\n" +
                "\t{\n" +
                "    \"empresa\" : \"Facebook\",\n" +
                "    \"cuenta\": \"EBITDA\",\n" +
                "    \"periodo\": \"2017\",\n" +
                "    \"monto\": 123456.45\n" +
                "    },\n" +
                "    {\n" +
                "    \"empresa\" : \"Facebook\",\n" +
                "    \"cuenta\": \"FDS\",\n" +
                "    \"periodo\": \"2017\",\n" +
                "    \"monto\": 156789.64\n" +
                "    },\n" +
                "    {\n" +
                "    \"empresa\" : \"Facebook\",\n" +
                "    \"cuenta\": \"EBITDA\",\n" +
                "    \"periodo\": \"2016\",\n" +
                "    \"monto\": 27832.23\n" +
                "    }\n" +
                "    {\n" +
                "    \"empresa\" : \"Facebook\",\n" +
                "    \"cuenta\": \"FDS\",\n" +
                "    \"periodo\": \"2017\",\n" +
                "    \"monto\": 156789.64\n" +
                "    }\n" +
                "]";
        return json;
    }

    public Cuenta cuentaFacebook(String periodo) {
        Cuenta cuenta = new Cuenta();
        cuenta.setEmpresa("Facebook");
        cuenta.setMonto(new BigDecimal(999));
        cuenta.setPeriodo(periodo);
        cuenta.setCuenta("ModeloInteresante");
        return cuenta;
    }

    public Cuenta cuentaTwitter(String periodo) {
        Cuenta cuenta = new Cuenta();
        cuenta.setEmpresa("Twitter");
        cuenta.setMonto(new BigDecimal(999));
        cuenta.setPeriodo(periodo);
        cuenta.setCuenta("ModeloInteresante");
        return cuenta;
    }

    public List<Cuenta> tresCuentas() {
        List<Cuenta> tresCuentas = new ArrayList<Cuenta>();
        tresCuentas.add(this.cuentaFacebook("2015"));
        tresCuentas.add(this.cuentaFacebook("2016"));
        tresCuentas.add(this.cuentaTwitter("2016"));
        return tresCuentas;
    }

    public CuentasUploadMock uploadDeTresCuentas() {
        CuentasUploadMock uploadDeTresCuentas = new CuentasUploadMock();
        uploadDeTresCuentas.setCuentas(this.tresCuentas());
        return uploadDeTresCuentas;
    }

}
