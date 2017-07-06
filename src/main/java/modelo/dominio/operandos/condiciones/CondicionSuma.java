package modelo.dominio.operandos.condiciones;

import modelo.dominio.operaciones.Operacion;

/**
 * Created by Ezequiel on 5/7/2017.
 */
public class CondicionSuma implements Condicion {
    //Despues veo la mejor manera de modelarlo
    Operacion condicion;

    public Operacion getCondicion() {
        return condicion;
    }

    public void setCondicion(Operacion condicion) {
        this.condicion = condicion;
    }
}
