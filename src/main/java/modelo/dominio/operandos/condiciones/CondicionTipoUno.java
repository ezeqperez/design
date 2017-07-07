package modelo.dominio.operandos.condiciones;

import modelo.dominio.Indicador;

public class CondicionTipoUno implements Condicion{
    private Indicador indicador;
    private String comparador;
    private Integer valor;
    private Integer anios;

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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getAnios() {
        return anios;
    }

    public void setAnios(Integer anios) {
        this.anios = anios;
    }
}
