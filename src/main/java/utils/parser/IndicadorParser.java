package utils.parser;

import javacc.ArithmeticParser;
import javacc.Token;
import modelo.dominio.Indicador;
import modelo.dominio.operandos.Valor;
import org.apache.commons.lang.math.NumberUtils;

import java.io.StringReader;

/**
 * Parser que recibe un string con la informacion de
 * el indicador, y devuelve un indicador construido.
 */
public class IndicadorParser {
    public Indicador generarIndicador(String nombre, String formula){
        StringReader sr = new StringReader(formula);
        ArithmeticParser arithmeticParser = new ArithmeticParser(sr);
        Indicador indicador = new Indicador();
        indicador.setNombre(nombre);
        indicador.setFormula(formula);

        indicador.setPrimerOperando(new Valor(NumberUtils.createBigDecimal(arithmeticParser.getNextToken().toString())));
        indicador.setSimbolo(arithmeticParser.getNextToken().toString());
        indicador.setSegundoOperando(new Valor(NumberUtils.createBigDecimal(arithmeticParser.getNextToken().toString())));
        return indicador;
    }
}
