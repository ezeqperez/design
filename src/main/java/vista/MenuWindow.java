package vista;

import modelo.EmpresasViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<EmpresasViewModel> {

    public MenuWindow(WindowOwner owner, EmpresasViewModel empresasViewModel) {
        super(owner, empresasViewModel);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("�Bienvenido!");
        Panel columnasPanel = new Panel(mainPanel);
        columnasPanel.setLayout(new ColumnLayout(2));

        new Button(columnasPanel).setCaption("Cargar cuentas").onClick(this::cargarCuentas);

        new Button(columnasPanel).setCaption("Consultar cuentas").onClick(this::buscarCuentas);

        new FileSelector(mainPanel)
                .setCaption("Buscar Archivo")
                .bindValueToProperty("ruta");
        new Label(mainPanel).bindValueToProperty("ruta");
    }

    private void cargarCuentas() {
        try {
            getModelObject().cargarEmpresas();
            mostrarAlerta("Las cuentas se cargaron correctamente :D");
        } catch (org.json.simple.parser.ParseException e) {
            throw new UserException("Hubo un problema al cargar el archivo");
        }
    }

    private void mostrarAlerta(String mensaje) {
        AlertWindow dialog = new AlertWindow(getOwner(), getModelObject(), mensaje);
        dialog.open();
    }

    private void buscarCuentas() {
        SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), getModelObject());
        dialog.open();
    }

    @Override
    protected void addActions(Panel arg0) {

    }

}