package utils;

import modelo.Cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentasUploadMock implements CuentasUploader {
    List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();

    public List<Cuenta> procesarArchivo() {
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

    public String getRuta() {
        return "ruta";
    }

    public void setRuta(String ruta) {

    }

    public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }
}
