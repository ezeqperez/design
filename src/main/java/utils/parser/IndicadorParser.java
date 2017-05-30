package utils.parser;

import javacc.ArithmeticParser;
import javacc.Token;
import modelo.dominio.Indicador;
import modelo.dominio.operandos.CuentaOperando;
import modelo.dominio.operandos.Valor;
import org.apache.commons.lang.math.NumberUtils;

import java.io.StringReader;
import java.util.Iterator;

/**
 * Parser que recibe un string con la informacion de
 * el indicador, y devuelve un indicador construido.
 */
public class IndicadorParser {
    private Indicador indicador = new Indicador();
    public Indicador generarIndicador(String nombre, String formula){
        StringReader sr = new StringReader(formula);
        ArithmeticParser arithmeticParser = new ArithmeticParser(sr);

        indicador.setNombre(nombre);
        indicador.setFormula(formula);
//        Token token = arithmeticParser.getNextToken();

        //Con alguna hermosa estructura como un for

        this.agregarAIndicador(arithmeticParser.getNextToken());
        this.agregarAIndicador(arithmeticParser.getNextToken());
        this.agregarAIndicador(arithmeticParser.getNextToken());
        this.llenarOperandos();
        return indicador;
    }

    private void agregarAIndicador(Token token) {
        if(token.kind == 9){
            indicador.setSimbolo(token.toString());
        }else if(token.kind == 11){
            indicador.addOperandos(new Valor(NumberUtils.createBigDecimal(token.toString())));
        }else if(token.kind == 12){
            indicador.addOperandos(new CuentaOperando(token.toString()));
        }
    }

    private void llenarOperandos(){
        indicador.setPrimerOperando(indicador.getOperandos().get(0));
        indicador.setSegundoOperando(indicador.getOperandos().get(1));
    }
}
