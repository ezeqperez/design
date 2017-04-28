package modelo;

public class CuentaNueva {

	
	private String cuentaNombre;
    private String periodo; //Struct periodo fechaDesde-fechaHasta tipos date
    private Integer valor;
    
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
    
}
