package utils;

import modelo.Cuenta;
import java.util.List;

public interface CuentasUploader {

    List<Cuenta> procesarArchivo(String ruta) throws org.json.simple.parser.ParseException;

}
