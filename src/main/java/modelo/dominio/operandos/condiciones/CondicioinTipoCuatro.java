package modelo.dominio.operandos.condiciones;

import modelo.dominio.Indicador;

public class CondicioinTipoCuatro implements Condicion{
    private Indicador indicador;
    private String comportamiento;
    private Integer periodo;

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
