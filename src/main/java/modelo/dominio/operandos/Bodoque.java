package modelo.dominio.operandos;

import modelo.dominio.Cuenta;
import modelo.dominio.Periodo;
import modelo.dominio.operaciones.Operacion;
import java.math.BigDecimal;
import java.util.List;

public class Bodoque implements Operando{

    private Operando primerOperando = null;
    private Operando segundoOperando = null;
    private Operacion operacion = null;

    @Override
    public BigDecimal valor(Periodo periodo) {
        return operacion.operar(primerOperando.valor(periodo), segundoOperando.valor(periodo));
    }

    public Operando getPrimerOperando() {
        return primerOperando;
    }

    public void setPrimerOperando(Operando primerOperando) {
        this.primerOperando = primerOperando;
    }

    public Operando getSegundoOperando() {
        return segundoOperando;
    }

    public void setSegundoOperando(Operando segundoOperando) {
        this.segundoOperando = segundoOperando;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

	@Override
	public boolean existe(List<Cuenta> cuentas) {
		return false;
	}

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
