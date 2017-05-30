package modelo.dominio;

import modelo.dominio.operaciones.Operacion;
import modelo.dominio.operandos.Operando;
import org.uqbar.commons.utils.Observable;
import java.math.BigDecimal;

@Observable
public class Indicador implements Operando {
    private String nombre;
    private String formula;
    private Operando primerOperando;
    private Operando segundoOperando;
    private String simbolo; //Seguro vuele, va de momento
    private Operacion operacion;

    @Override
    public BigDecimal valor(Periodo periodo) {
        return operacion.operar(primerOperando.valor(periodo), segundoOperando.valor(periodo));
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

    public void setPrimerOperando(Operando primerOperando) {
        this.primerOperando = primerOperando;
    }

    public void setSegundoOperando(Operando segundoOperando) {
        this.segundoOperando = segundoOperando;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
