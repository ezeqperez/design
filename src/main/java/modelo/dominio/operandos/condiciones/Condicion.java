package modelo.dominio.operandos.condiciones;

import modelo.dominio.operaciones.Operacion;

public interface Condicion {
    //Hay que definir como necesitan que se comporte una condicion
    public Operacion getCondicion();

    public void setCondicion(Operacion condicion);

}
