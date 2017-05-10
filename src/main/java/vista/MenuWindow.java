package vista;

import modelo.CuentasViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

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
        
        new Button(columnasPanel).setCaption("Cargar cuentas").onClick(() -> this.cargarCuentas());

        new Button(columnasPanel).setCaption("Consultar cuentas").onClick(() -> this.buscarCuentas());
    }

    private void cargarCuentas() {
        try {
            getModelObject().cargarCuentas();
            mostrarAlerta("Las cuentas se cargaron correctamente :D");
        } catch (org.json.simple.parser.ParseException e) {
            throw new UserException("Hubo un problema al cargar el archivo");
        }
    }

    public void mostrarAlerta(String mensaje) {
        AlertWindow dialog = new AlertWindow(getOwner(), getModelObject(), mensaje);
        dialog.open();
    }

    public void buscarCuentas() {
        SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), getModelObject());
        dialog.open();
    }

    @Override
    protected void addActions(Panel arg0) {

    }

}