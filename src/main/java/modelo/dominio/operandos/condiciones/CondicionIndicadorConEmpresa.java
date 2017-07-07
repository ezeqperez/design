package modelo.dominio.operandos.condiciones;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;

public class CondicionIndicadorConEmpresa implements Condicion{
    private Indicador indicador;
    private String comparador;
    private Empresa empresa;

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getComparador() {
        return comparador;
    }

    public void setComparador(String comparador) {
        this.comparador = comparador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
