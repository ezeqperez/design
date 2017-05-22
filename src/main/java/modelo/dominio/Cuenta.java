package modelo.dominio;

import org.uqbar.commons.utils.Observable;
import java.math.BigDecimal;

@Observable
public class Cuenta {
    private String nombre;
    private BigDecimal monto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
