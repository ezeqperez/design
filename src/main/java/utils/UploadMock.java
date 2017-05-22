package utils;

import modelo.dominio.Cuenta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UploadMock implements Uploader {
    List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public List<Cuenta> procesarArchivo(String ruta) {
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setEmpresa("Facebook");
        cuenta1.setMonto(new BigDecimal(999));
        cuenta1.setPeriodo("2016");
        cuenta1.setCuenta("ModeloInteresante");
        List<Cuenta> tresCuentas = new ArrayList<Cuenta>();
        tresCuentas.add(cuenta1);
        tresCuentas.add(cuenta1);
        tresCuentas.add(cuenta1);

        return tresCuentas;
    }


    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}