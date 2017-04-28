package vista;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.CuentasViewModel;
import utils.CuentasUpload;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<CuentasViewModel> {
	CuentasUpload cuentasUpload;

	public MenuWindow(WindowOwner owner, CuentasViewModel cuentasViewModel) {
		super(owner, cuentasViewModel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("¡Bienvenido!");
		Panel columnasPanel = new Panel(mainPanel);
		columnasPanel.setLayout(new ColumnLayout(2));
		
		new Label(mainPanel).setText("Menú principal:");

		new Button(columnasPanel).setCaption("Cargar cuentas").onClick(() -> this.cargarCuentas());

		new Button(columnasPanel).setCaption("Consultar cuentas").onClick(() -> this.buscarCuentas());

		new Button(columnasPanel).setCaption("Crear nuevo indicador").onClick(() -> this.avisarNoimplemento());

		new Button(columnasPanel).setCaption("Consultar indicadores").onClick(() -> this.avisarNoimplemento());

		new Button(columnasPanel).setCaption("Consultar gráficos").onClick(() -> this.avisarNoimplemento());
		
		new Button(columnasPanel).setCaption("Crear nueva metodología").onClick(() -> this.avisarNoimplemento());
		
		new Button(columnasPanel).setCaption("Nuevo análisis").onClick(() -> this.avisarNoimplemento());

	}
	
    public void avisarNoimplemento(){
    	ErrorWindow dialog = new ErrorWindow(getOwner(), getModelObject());
    	dialog.setMensaje("Todavía en construcción :|");
		dialog.open();
    }
    
    public void cargarCuentas(){
    	getModelObject().cargarCuentas();
    }

    public void buscarCuentas(){
    	SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), getModelObject());
    	dialog.open();
    }
    
	@Override
	protected void addActions(Panel arg0) {

	}

}