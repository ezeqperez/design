package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

public class Periodo {

    private List<Cuenta> cuentas = new ArrayList<>();
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

