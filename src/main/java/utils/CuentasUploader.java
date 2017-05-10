package utils;

import modelo.Cuenta;

import java.util.List;


public interface CuentasUploader {

    public List<Cuenta> procesarArchivo() throws org.json.simple.parser.ParseException;

    public String getRuta();


    public void setRuta(String ruta);

}
