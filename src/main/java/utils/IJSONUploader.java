package utils;

import modelo.Cuenta;
import modelo.Empresa;

import java.util.List;


public interface IJSONUploader {

    public List<Empresa> procesarArchivo(String ruta) throws org.json.simple.parser.ParseException;

}
