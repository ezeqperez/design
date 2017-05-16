package modelo;

import java.util.List;

/**
 * Created by feder on 14/05/2017.
 */
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

