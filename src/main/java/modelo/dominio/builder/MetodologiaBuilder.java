package modelo.dominio.builder;

import modelo.dominio.Metodologia;
import modelo.dominio.operaciones.Suma;
import modelo.dominio.operandos.condiciones.Condicion;
import modelo.dominio.operandos.condiciones.CondicionSuma;
import modelo.repositorios.MetodologiasRepository;

import java.util.ArrayList;
import java.util.List;

public class MetodologiaBuilder {
    List<Condicion> condiciones = new ArrayList<Condicion>();
    String nombre;

    public void setCondicionSuma(){
        Condicion condicionSuma = new CondicionSuma();
        //Tiene sentido esto? la suma digo
        condicionSuma.setCondicion(new Suma());
        condiciones.add(condicionSuma);
    }


    public void build(){
        Metodologia metodologia = new Metodologia();
        metodologia.setNombre(nombre);
        metodologia.setCondiciones(condiciones);
        MetodologiasRepository.getInstance().insert(metodologia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
