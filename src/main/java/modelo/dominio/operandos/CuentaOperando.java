package modelo.dominio.operandos;

import modelo.dominio.Periodo;
import java.math.BigDecimal;
import java.util.List;

public class CuentaOperando implements Operando{
    private String nombreCuenta;

    public CuentaOperando(String nombre){
        this.nombreCuenta= nombre;
    }

    @Override
    //De alguna manera tambien le tengo que hacer llegar la empresa
    public BigDecimal valor(Periodo periodo){
        return periodo.getMonto(nombreCuenta);
    }


/*
    Calculo aca los valores de todos los valores de las cuentas, y los sumo

    public double getCostoTotal (Tarea tarea) {
        return this.subtareas.stream().mapToDouble(subtarea -> subtarea.getCostoTotal()).sum();
    }
*/
}
