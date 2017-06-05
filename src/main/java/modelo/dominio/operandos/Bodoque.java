package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import modelo.dominio.operaciones.Operacion;
import java.math.BigDecimal;

public class Bodoque implements Operando{

    private Operando primerOperando;
    private Operando segundoOperando;
    private Operacion operacion;

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

}
