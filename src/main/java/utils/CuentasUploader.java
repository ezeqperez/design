package utils;

import modelo.Cuenta;

import java.util.List;


public interface CuentasUploader {

    public List<Cuenta> procesarArchivo(String ruta) throws org.json.simple.parser.ParseException;

}
