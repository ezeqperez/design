package vista;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.CuentasViewModel;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<CuentasViewModel> {

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

		new Button(columnasPanel).setCaption("Crear nuevo indicador").onClick(() -> this.mostrarError("Todavía en construcción :|"));

		new Button(columnasPanel).setCaption("Consultar indicadores").onClick(() -> this.mostrarError("Todavía en construcción :|"));

		new Button(columnasPanel).setCaption("Consultar gráficos").onClick(() -> this.mostrarError("Todavía en construcción :|"));
		
		new Button(columnasPanel).setCaption("Crear nueva metodología").onClick(() -> this.mostrarError("Todavía en construcción :|"));
		
		new Button(columnasPanel).setCaption("Nuevo análisis").onClick(() -> this.mostrarError("Todavía en construcción :|"));

	}
	
    private void cargarCuentas() {
    	getModelObject().cargarCuentas();
    	this.mostrarError("Las cuentas se cargaron correctamente :D");
	}
    
    public void mostrarError(String mensaje){
    	AlertWindow dialog = new AlertWindow(getOwner(), getModelObject(), mensaje);
		dialog.open();
    }

    public void buscarCuentas(){
    	SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), getModelObject());
    	dialog.open();
    }
    
	@Override
	protected void addActions(Panel arg0) {

	}

}