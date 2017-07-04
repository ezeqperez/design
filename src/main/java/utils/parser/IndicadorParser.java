package utils.parser;

import modelo.dominio.Indicador;
import modelo.javacc.ArithmeticParser;
import modelo.javacc.ParseException;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.model.UserException;

import java.io.StringReader;

/**
 * Parser que recibe un string con la informacion de
 * el indicador, y devuelve un indicador construido.
 */
public class IndicadorParser {

    private Indicador indicador = null;

    public void generarIndicador(String nombre, String formula){
        final StringReader sr = new StringReader(formula);
        final ArithmeticParser arithmeticParser = new ArithmeticParser(sr);
        try {
             arithmeticParser.Start();
             indicador = new Indicador();
             indicador.setBodoque(arithmeticParser.getBodoqueDevolver());
             indicador.setNombre(nombre);
             IndicadoresRepository.getInstance().update(indicador);
        }catch(final ParseException e){
            throw new UserException("La formula que ingreso no es valida, por favor intente de nuevo");
        }
    }
}
