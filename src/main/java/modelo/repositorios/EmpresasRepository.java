package modelo.repositorios;

import modelo.dominio.Empresa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpresasRepository {

    private List<Empresa> empresas;

    public EmpresasRepository() {
        empresas = new ArrayList<>();
    }

    private static EmpresasRepository ourInstance = new EmpresasRepository();

    public static EmpresasRepository getInstance() {
        return ourInstance;
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

    public void insert(Empresa empresa){
        empresas.add(empresa);
    }

    public Empresa search(String name) {
        return empresas.stream().filter(empresa -> empresa.getNombre() == name).findFirst().orElse(null);
    }

    public void update(Empresa empresa) {
        delete(search(empresa.getNombre()));
        insert(empresa);
    }

    public void delete(Empresa empresa) {
        empresas.remove(empresa);
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<String> getEmpresasPorNombre() {
        return empresas.stream().map(Empresa::getNombre).collect(Collectors.toList());
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
