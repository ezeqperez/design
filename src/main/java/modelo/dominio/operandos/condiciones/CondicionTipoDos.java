package modelo.dominio.operandos.condiciones;

import modelo.dominio.Indicador;

public class CondicionTipoDos implements Condicion{
    private Indicador indicador;
    private String comparador;
    private String empresa; //mepa que no hace falta guardar tooodo el objeto empresa, con guardar el nombre y buscarlo por él en el repo ..

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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
