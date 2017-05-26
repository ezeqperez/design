package modelo.dominio;

import modelo.dominio.operaciones.Operacion;
import modelo.dominio.operandos.Operando;
import org.uqbar.commons.utils.Observable;
import java.math.BigDecimal;

@Observable
public class Indicador implements Operando {
    private String nombre;
    private String formula;
    private Operando rOperando;
    private Operando lOperando;
    private Operacion operacion;

    @Override
    public BigDecimal valor(Periodo periodo) {
        return operacion.operar(lOperando.valor(periodo), rOperando.valor(periodo));
    }

    public String getNombre() {
        return nombre;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setrOperando(Operando rOperando) {
        this.rOperando = rOperando;
    }

    public void setlOperando(Operando lOperando) {
        this.lOperando = lOperando;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
}
