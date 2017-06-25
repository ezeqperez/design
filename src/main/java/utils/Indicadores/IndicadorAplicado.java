package utils.Indicadores;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

@Observable
public class IndicadorAplicado {

	private String nombreEmpresa;
	private int anioPeriodo;
	private String nombreIndicador;
	private BigDecimal valor;
	private boolean existe;
	
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getAnioPeriodo() {
		return anioPeriodo;
	}

	public void setAnioPeriodo(int anioPeriodo) {
		this.anioPeriodo = anioPeriodo;
	}

	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal bd) {
		this.valor = bd;
		
	}

	public boolean getExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

}
