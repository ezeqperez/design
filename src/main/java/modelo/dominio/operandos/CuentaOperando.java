package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import modelo.repositorios.EmpresasRepository;

import java.math.BigDecimal;
import java.util.List;

public class CuentaOperando implements Operando{
    private String nombreCuenta;

    public CuentaOperando(String nombre){
        nombreCuenta= nombre;
    }

    @Override
    //De alguna manera tambien le tengo que hacer llegar la empresa

    //ojo que esta no es la misma cuenta que esta cargada
    //enttonces al devolver un valor, tiene que ir al repo buscar por nombre y traer el valor
    public BigDecimal valor(Periodo periodo){
        //EmpresasRepository.getInstance(); -- mme aprece que tmb necesito saber la empresa..
        return periodo.getMonto(nombreCuenta);
    }


/*
    Calculo aca los valores de todos los valores de las cuentas, y los sumo

    public double getCostoTotal (Tarea tarea) {
        return this.subtareas.stream().mapToDouble(subtarea -> subtarea.getCostoTotal()).sum();
    }
*/
}
