package modelo;
import java.util.Date;

import org.eclipse.swt.widgets.DateTime;


public class Periodo {

	DateTime fechaDesde;
	DateTime fechaHasta;
	
	
	public DateTime getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(DateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public DateTime getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(DateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	
}
