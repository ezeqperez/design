package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import java.math.BigDecimal;

public class CuentaOperando implements Operando{
    private String nombre;

    @Override
    public BigDecimal valor(Periodo periodo) {
        return periodo.getMonto(nombre);
    }
}
