package modelo.dominio;

import modelo.dominio.operaciones.Operacion;
import modelo.dominio.operandos.Operando;
import org.uqbar.commons.utils.Observable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Observable
public class Indicador implements Operando, Serializable {
	
    private String nombre;
    private String formula;


    private Operando primerOperando;
    private Operando segundoOperando;
    private String simbolo; //Seguro vuele, va de momento
    private Operacion operacion;

    private List<Operando> operandos = new ArrayList<Operando>(); //vamos a ver si conviene
    
	private static final long serialVersionUID = 1L;


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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List<Operando> getOperandos() {
        return operandos;
    }

    public void setOperandos(List<Operando> operandos) {
        this.operandos = operandos;
    }

    public void addOperandos(Operando operando){
        this.operandos.add(operando);
    }
}
