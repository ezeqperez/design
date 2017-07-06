package modelo.dominio.operandos.condiciones;

import modelo.dominio.operaciones.Operacion;

public interface Condicion {
    public Operacion getCondicion();

    public void setCondicion(Operacion condicion);

}
