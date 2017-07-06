package modelo.dominio.builder;

import modelo.dominio.Metodologia;
import modelo.dominio.operaciones.Operacion;
import modelo.dominio.operaciones.Suma;
import modelo.dominio.operandos.condiciones.Condicion;
import modelo.dominio.operandos.condiciones.CondicionSuma;
import modelo.repositorios.MetodologiasRepository;

import java.util.ArrayList;
import java.util.List;

public class MetodologiaBuilder {
    List<Condicion> condiciones = new ArrayList<Condicion>();

    public void setCondicionSuma(){
        Condicion condicionSuma = new CondicionSuma();
        //Tiene sentido esto?
        condicionSuma.setCondicion(new Suma());
        condiciones.add(condicionSuma);
    }

    public void build(){
        Metodologia metodologia = new Metodologia();
        metodologia.setCondiciones(condiciones);
        MetodologiasRepository.getInstance().insert(metodologia);

        //Esto no tiene que ser así, sino crear una instancia de builder dentro del MetodologiaWindow
        //De momento lo arreglo con esta cosa horrible
        condiciones = new ArrayList<Condicion>();
    }

}
