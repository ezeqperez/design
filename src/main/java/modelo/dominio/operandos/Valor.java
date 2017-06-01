package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;

public class Valor implements Operando {
    private final BigDecimal valor;

    public Valor(String valor) {
        this.valor = NumberUtils.createBigDecimal(valor);
    }

    @Override
    public BigDecimal valor(Periodo periodo) {
        return getValor();
    }

    public BigDecimal getValor() {
        return valor;
    }

}
