package utils.parser;

import javacc.ArithmeticParser;
import javacc.Token;
import modelo.dominio.Indicador;
import modelo.dominio.operandos.CuentaOperando;
import modelo.dominio.operandos.Operando;
import modelo.dominio.operandos.Valor;

import java.io.StringReader;

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

        indicador.setPrimerOperando(this.obtenerOperando(arithmeticParser.getNextToken()));
        indicador.setSimbolo(arithmeticParser.getNextToken().toString());
        indicador.setSegundoOperando(this.obtenerOperando(arithmeticParser.getNextToken()));

        return indicador;
    }

    /*
    * Si es un numero, lo cargo como un Valor.
    * si llega a ser una cuenta o un indicador, lo voy a guardar como Valor Compuesto,
    * (ahora llamado CuentaOperando), lo que quiero es para luego calcular, que el valor
    *  me sepa devolver el mismo valor que tiene (que devuelve mi parser), si llega a ser
    *  una Cuenta, tiene que devolverme el costo de la misma, y si llega a ser un Indicador,
    *  debe calcular los valores de todos sus operadores.
    */
    private Operando obtenerOperando(Token token) {
        //Valores numericos
        if(token.kind == 11){
            return new Valor(token.toString());
        //Cuentas
        }else if(token.kind == 12) {
            //Debo ver si esta cuenta existe
            return new CuentaOperando(token.toString());
        }
        return null;
    }
}
