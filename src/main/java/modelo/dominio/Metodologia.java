package modelo.dominio;

import modelo.dominio.operandos.condiciones.Condicion;
import org.uqbar.commons.utils.Observable;
import vista.MetodologiasMock.MetodologiasMock;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Metodologia {

    String nombre = null;
    //List<Condicion> condiciones = new ArrayList<>();

    public List<Empresa> aplicar(List<Empresa> empresas){
        //TODO aplicar condiciones y bla
        return MetodologiasMock.getEmpresasFiltradas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
