package modelo.dominio;

import modelo.dominio.Cuenta;

import java.util.List;

public class Periodo {

    private List<Cuenta> cuentas;
    private int anio;

    public int getPeriodo (){
        return anio;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}

