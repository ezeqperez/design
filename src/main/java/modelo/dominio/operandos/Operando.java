package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import java.math.BigDecimal;

public interface Operando {
    BigDecimal valor(Periodo periodo);

}
