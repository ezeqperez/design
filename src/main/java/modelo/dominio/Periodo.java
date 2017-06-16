package modelo.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import modelo.dominio.operandos.Operando;
import utils.Excepciones.ExcepcionFiltroViewModel;
import utils.Excepciones.ExcepcionPeriodoSinCuenta;

public class Periodo {

	private List<Cuenta> cuentas = new ArrayList<>();
	private int anio;

	public int getPeriodo() {
		return anio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta findCuenta(String nombre) {
		return cuentas.stream()
				.filter(cuenta -> cuenta.getNombre().equals(nombre))
				.findFirst()
				.orElseThrow(() -> new ExcepcionPeriodoSinCuenta("Este período, no posee cuentas"));
	}

	public BigDecimal getMonto(String nombre) {
		return findCuenta(nombre).getMonto();
	}

	//Chequeo si los operandos estan 
	//en los periodos
	/*public boolean existenCuentas(Operando operando1, Operando operando2) {
		if (operando1.existe(this.getCuentas()) && operando2.existe(this.getCuentas()))
			return true;
		else
			return false;
	}*/
}
