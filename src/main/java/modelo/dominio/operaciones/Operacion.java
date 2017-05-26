package modelo.dominio.operaciones;

import java.math.BigDecimal;

public interface Operacion {
    BigDecimal operar(BigDecimal lOperando, BigDecimal rOperando);
}
