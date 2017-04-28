package vista;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.CuentasViewModel;

@SuppressWarnings("serial")
public class ErrorWindow extends Dialog<CuentasViewModel>{
	
	private String mensaje;

	public ErrorWindow(WindowOwner owner, CuentasViewModel model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		new Label(mainPanel).setText(mensaje);
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
