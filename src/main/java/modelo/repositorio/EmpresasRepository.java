package modelo.repositorio;

import modelo.Empresa;
import java.util.List;
/**
 * Created by feder on 14/05/2017.
 */
public class EmpresasRepository {

    private List<Empresa> empresas;

    public void agregarEmpresas(List<Empresa> empresasAAgregar) throws org.json.simple.parser.ParseException {
        empresas.addAll(empresasAAgregar);
    }

    public Empresa filtrarEmpresas (String nombre) {
        for (Empresa e : empresas) {
            if (e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }
        return null;
    }





}
