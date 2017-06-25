package modelo.dominio.operandos;

import modelo.dominio.Cuenta;
import modelo.dominio.Periodo;
import org.apache.commons.lang.math.NumberUtils;
import java.math.BigDecimal;
import java.util.List;

public class Valor implements Operando {

    private BigDecimal valor;

    public Valor(String valor) {
        this.valor = NumberUtils.createBigDecimal(valor);;
    }

    @Override
    public BigDecimal valor(Periodo periodo) {
        return valor;
    }

	@Override
	public boolean existe(List<Cuenta> cuentas) {
		return true;
	}
	
	public String nombre(){
		return "valor";
	}

}
