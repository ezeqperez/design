package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import modelo.dominio.operandos.Operando;

import java.math.BigDecimal;

public class Valor implements Operando {
    private BigDecimal valor;

    public Valor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal valor(Periodo periodo) {
        return getValor();
    }

    public BigDecimal getValor() {
        return valor;
    }

}
