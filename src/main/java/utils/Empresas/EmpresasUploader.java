package utils.Empresas;

import modelo.dominio.Empresa;
import java.util.List;

public interface EmpresasUploader {

    public List<Empresa> procesarArchivo(String ruta) throws org.json.simple.parser.ParseException;
}
