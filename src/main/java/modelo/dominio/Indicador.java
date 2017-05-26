package modelo.dominio;

import modelo.dominio.operaciones.Operacion;
import org.uqbar.commons.utils.Observable;
import java.math.BigDecimal;

@Observable
public class Indicador implements Operando{
    private String nombre;
    private String formula;
    private Operando rOperando;
    private Operando lOperando;
    private Operacion operacion;

    @Override
    public BigDecimal valor(Periodo periodo) {
        return getOperacion().operar(getlOperando().valor(periodo), getrOperando().valor(periodo));
    }

    public Operando getrOperando() {
        return rOperando;
    }

    public Operando getlOperando() {
        return lOperando;
    }

    public Operacion getOperacion() {
        return operacion;
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
