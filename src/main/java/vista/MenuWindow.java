package vista;

import modelo.CuentasProceso;
import modelo.CuentasUpload;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<CuentasProceso>{
	CuentasUpload cuentasUpload;
	public MenuWindow(WindowOwner owner, CuentasProceso cuentasProceso) {
		super(owner, cuentasProceso);

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Carga de archivo");
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).setText("Pantalla de carga de cuentas");

		new Button(mainPanel)
				.setCaption("Cargar archivo")
				.onClick(()-> getModelObject().cargarCuentas());


	}

	@Override
	protected void addActions(Panel arg0) {

	}

}