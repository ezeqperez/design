import modelo.Cuenta;
import utils.CuentasUploadMock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezequiel on 24/4/2017.
 */
public class Fixture {
    public String jsonMalo(){
        String obj = "{\n" +
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
        return obj;
    }

    public Cuenta cuentaFacebook(String periodo){
        Cuenta cuenta = new Cuenta();
        cuenta.setEmpresa("Facebook");
        cuenta.setMonto(new BigDecimal(999));
        cuenta.setPeriodo(periodo);
        cuenta.setCuenta("ModeloInteresante");
        return cuenta;
    }
    public Cuenta cuentaTwitter(String periodo){
        Cuenta cuenta = new Cuenta();
        cuenta.setEmpresa("Twitter");
        cuenta.setMonto(new BigDecimal(999));
        cuenta.setPeriodo(periodo);
        cuenta.setCuenta("ModeloInteresante");
        return cuenta;
    }
    public List<Cuenta> tresCuentas(){
        List<Cuenta> tresCuentas = new ArrayList<Cuenta>();
        tresCuentas.add(this.cuentaFacebook("2015"));
        tresCuentas.add(this.cuentaFacebook("2016"));
        tresCuentas.add(this.cuentaTwitter("2016"));
        return tresCuentas;
    }

    public CuentasUploadMock uploadDeTresCuentas() {
        CuentasUploadMock uploadDeTresCuentas = new CuentasUploadMock();
        uploadDeTresCuentas.setListaDeCuentas(this.tresCuentas());
        return uploadDeTresCuentas;
    }

}
