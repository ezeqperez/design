package test.Indicadores;

import modelo.javacc.ArithmeticParser;
import modelo.javacc.ParseException;
import org.junit.Test;

import java.io.StringReader;

public class ArithmeticParserTest {

    @Test
    public void parseaOkUnaSumaDeConstantes() throws ParseException{
        final StringReader sr = new StringReader("2+2");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosSimbolosJuntos() throws ParseException{
        final StringReader sr = new StringReader("2++2");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosNumerosJuntos() throws ParseException{
        final StringReader sr = new StringReader("22 22+2");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test
    public void sumaDeCuentas() throws ParseException{
        final StringReader sr = new StringReader("cuenta1 + cuenta2");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosStringSinOperador() throws ParseException{
        final StringReader sr = new StringReader("cuenta1 cuenta2");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void comienzaConSimbolo() throws ParseException{
        final StringReader sr = new StringReader("+2+3");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void terminaConSimbolo() throws ParseException{
        final StringReader sr = new StringReader("cuenta+sarasa-");
        final ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }
}
