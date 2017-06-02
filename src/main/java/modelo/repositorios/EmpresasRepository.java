package modelo.repositorios;

import modelo.dominio.Empresa;
import java.util.ArrayList;
import java.util.List;

public class EmpresasRepository {

    private List<Empresa> empresas = new ArrayList<>();

    private static EmpresasRepository ourInstance = new EmpresasRepository();

    public static EmpresasRepository getInstance() {
        return ourInstance;
    }
    
    public List<Empresa> getEmpresas(){
    	return empresas;
    }


    public void agregarEmpresas(List<Empresa> empresasAAgregar) {
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
