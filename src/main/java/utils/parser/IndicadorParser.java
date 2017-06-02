package utils.parser;

import javacc.ArithmeticParser;
import javacc.ParseException;
import javacc.Token;
import modelo.dominio.Indicador;
import modelo.dominio.operandos.CuentaOperando;
import modelo.dominio.operandos.Operando;
import modelo.dominio.operandos.Valor;
import org.uqbar.commons.model.UserException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser que recibe un string con la informacion de
 * el indicador, y devuelve un indicador construido.
 */
public class IndicadorParser {

    private Indicador indicador = new Indicador();
    private List<Token> tokens = new ArrayList<Token>();

    public Indicador generarIndicador(String nombre, String formula){
        StringReader sr = new StringReader(formula);
        ArithmeticParser arithmeticParser = new ArithmeticParser(sr);
        try {
            arithmeticParser.Start();
        }catch(ParseException e){
            throw new UserException("La formula que ingreso no es valida, por favor intente denuevo");
        }

        indicador.setNombre(nombre);
        indicador.setFormula(formula);

        //El primerOperador está muy acoplado, recibe un token, no encuentro otra manera
        indicador.setPrimerOperando(this.obtenerOperando(arithmeticParser.getOperando1()));
        indicador.setSimbolo(arithmeticParser.getOperacion());
        indicador.setSegundoOperando(new Valor(arithmeticParser.getOperando2()));


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
