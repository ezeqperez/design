package modelo.dominio;

import java.math.BigDecimal;
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

    public Cuenta findCuenta(String nombre) {
    return cuentas.stream().filter(cuenta -> cuenta.getNombre() == nombre).findFirst().orElse(null);
    }

    public BigDecimal getMonto(String nombre) {
        return findCuenta(nombre).getMonto();
    }
}

