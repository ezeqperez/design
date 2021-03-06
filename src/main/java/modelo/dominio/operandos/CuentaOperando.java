package modelo.dominio.operandos;

import modelo.dominio.Cuenta;
import modelo.dominio.Periodo;
import java.math.BigDecimal;
import java.util.List;

public class CuentaOperando implements Operando {
	private String nombreCuenta;
	private boolean estado = false;

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public CuentaOperando(String nombre) {
		nombreCuenta = nombre;
	}

	@Override
	// De alguna manera tambien le tengo que hacer llegar la empresa

	// ojo que esta no es la misma cuenta que esta cargada
	// enttonces al devolver un valor, tiene que ir al repo buscar por nombre y
	// traer el valor
	public BigDecimal valor(Periodo periodo) {
		// EmpresasRepository.getInstance(); -- mme aprece que tmb necesito
		// saber la empresa..
		return periodo.getMonto(nombreCuenta);
	}

	@Override
	public boolean existe(List<Cuenta> cuentas) {
		estado = false;
		cuentas.forEach(cuentaItem -> {
			if (cuentaItem.getNombre().equals(nombreCuenta)) {
				estado = true;
			}

		});
		return estado;
	}

	public String nombre() {
		return nombreCuenta;
	}

}
