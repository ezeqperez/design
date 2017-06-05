package modelo.dominio;

import modelo.dominio.operandos.Bodoque;
import org.uqbar.commons.utils.Observable;

@Observable
public class Indicador{

	private String nombre;
	private Bodoque bodoque;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Bodoque getBodoque() {
		return bodoque;
	}

	public void setBodoque(Bodoque bodoque) {
		this.bodoque = bodoque;
	}
}
