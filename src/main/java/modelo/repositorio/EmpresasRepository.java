package modelo.repositorio;

import modelo.dominio.Empresa;
import java.util.List;

public class EmpresasRepository {

    private List<Empresa> empresas;

    public void agregarEmpresas(List<Empresa> empresasAAgregar) throws org.json.simple.parser.ParseException {
        empresas.addAll(empresasAAgregar);
    }

    public Empresa filtrarEmpresas (String nombre) {
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equalsIgnoreCase(nombre)){
                return empresa;
            }
        }
        return null;
    }





}
