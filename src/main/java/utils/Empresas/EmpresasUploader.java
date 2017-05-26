package utils.Empresas;

import modelo.dominio.Empresa;
import org.json.simple.parser.ParseException;
import java.util.List;

public interface EmpresasUploader {

    List<Empresa> procesarArchivo(String ruta) throws ParseException;
}
