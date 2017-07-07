package modelo.dominio.builder;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.Metodologia;
import modelo.dominio.operandos.condiciones.*;
import modelo.repositorios.MetodologiasRepository;

import java.util.ArrayList;
import java.util.List;

public class MetodologiaBuilder {
    private List<Condicion> condiciones = new ArrayList<>();
    private String nombre;

    public void setCondicionNumero(Indicador indicador, String comparador, Integer valor){
        CondicionNumerica condicionNumero = new CondicionNumerica();
        condicionNumero.setIndicador(indicador);
        condicionNumero.setComparador(comparador);
        condicionNumero.setValor(valor);
        condiciones.add(condicionNumero);
    }

    public void setCondicionIndicadorEmpresa(Indicador indicador, String comparador, Empresa empresa) {
        CondicionIndicadorConEmpresa condicionEmpresa = new CondicionIndicadorConEmpresa();
        condicionEmpresa.setIndicador(indicador);
        condicionEmpresa.setComparador(comparador);
        condicionEmpresa.setEmpresa(empresa);
        condiciones.add(condicionEmpresa);
    }

    public void setCondicionConCriterio(String criterio, Indicador indicador, String comparador, Integer valor) {
        CondicionCriterio condicionCriterio = new CondicionCriterio();
        condicionCriterio.setCriterio(criterio);
        condicionCriterio.setIndicador(indicador);
        condicionCriterio.setComparador(comparador);
        condicionCriterio.setValor(valor);
        condiciones.add(condicionCriterio);
    }

    public void setCondicionCrecimiento(String comportamiento, Indicador indicador, String comparador, Integer valor) {
        CondicionCrecimiento condicionCrecimiento = new CondicionCrecimiento();
        condicionCrecimiento.setCrecimiento(comportamiento);
        condicionCrecimiento.setIndicador(indicador);
        condicionCrecimiento.setComparador(comparador);
        condicionCrecimiento.setValor(valor);
        condiciones.add(condicionCrecimiento);
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
