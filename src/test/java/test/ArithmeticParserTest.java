package test;

import modelo.dominio.Indicador;
import modelo.javacc.ArithmeticParser;
import modelo.javacc.ParseException;
import modelo.repositorios.IndicadoresRepository;
import modelo.viewModel.IndicadorViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

public class ArithmeticParserTest {

    @Test
    public void parseaOkUnaSumaDeConstantes() throws ParseException{
        StringReader sr = new StringReader("2+2");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosSimbolosJuntos() throws ParseException{
        StringReader sr = new StringReader("2++2");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosNumerosJuntos() throws ParseException{
        StringReader sr = new StringReader("22 22+2");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test
    public void sumaDeCuentas() throws ParseException{
        StringReader sr = new StringReader("cuenta1 + cuenta2");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void dosStringSinOperador() throws ParseException{
        StringReader sr = new StringReader("cuenta1 cuenta2");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void comienzaConSimbolo() throws ParseException{
        StringReader sr = new StringReader("+2+3");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }

    @Test  (expected = ParseException.class)
    public void terminaConSimbolo() throws ParseException{
        StringReader sr = new StringReader("cuenta+sarasa-");
        ArithmeticParser parser = new ArithmeticParser(sr);
        parser.Start();
    }
}
