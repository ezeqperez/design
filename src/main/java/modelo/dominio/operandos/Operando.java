package modelo.dominio.operandos;

import modelo.dominio.Cuenta;
import modelo.dominio.Periodo;
import java.math.BigDecimal;
import java.util.List;

public interface Operando {
    BigDecimal valor(Periodo periodo);
    boolean existe(List<Cuenta> cuentas);
    String nombre();
}
