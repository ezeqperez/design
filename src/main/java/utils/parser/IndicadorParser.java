package utils.parser;

import javacc.ArithmeticParser;
import javacc.ParseException;
import modelo.dominio.Indicador;
import org.uqbar.commons.model.UserException;

import java.io.StringReader;

/**
 * Parser que recibe un string con la informacion de
 * el indicador, y devuelve un indicador construido.
 */
public class IndicadorParser {

    private Indicador indicador;
    public void generarIndicador(String nombre, String formula){
        StringReader sr = new StringReader(formula);
        ArithmeticParser arithmeticParser = new ArithmeticParser(sr);

        try {
             arithmeticParser.Start();
        }catch(ParseException e){
            throw new UserException("La formula que ingreso no es valida, por favor intente de nuevo");
        }


        arithmeticParser.setNombre(nombre);
        arithmeticParser.setFormula(formula);

        arithmeticParser.guardarIndicador();
    }
}
