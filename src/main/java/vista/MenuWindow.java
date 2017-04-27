package vista;

import modelo.CuentasViewModel;
import modelo.CuentasUpload;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<CuentasViewModel>{
	CuentasUpload cuentasUpload;
	public MenuWindow(WindowOwner owner, CuentasViewModel cuentasViewModel) {
		super(owner, cuentasViewModel);

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Carga de archivo");
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).setText("Pantalla de carga de cuentas");

		new Button(mainPanel)
				.setCaption("Cargar archivo")
				.onClick(()-> getModelObject().cargarCuentas());

		new Label(mainPanel).setText("Empresa");
		new TextBox(mainPanel)
				.setWidth(50)
				.bindValueToProperty("empresa");

		new Label(mainPanel).setText("Periodo");
		new TextBox(mainPanel)
				.setWidth(50)
				.bindValueToProperty("periodo");

		//TODO: Puedo antes de mandar el mensaje al modelObject, preguntar por si "empresa" y "periodo" son null?
		new Button(mainPanel)
				.setCaption("Buscar Cuentas")
				.onClick(()-> getModelObject().filtrarCuentas());



	}

	@Override
	protected void addActions(Panel arg0) {

	}

}