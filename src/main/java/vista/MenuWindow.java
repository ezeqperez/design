package vista;

import modelo.dominio.Cuenta;
import modelo.viewModel.EmpresasViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;
import modelo.viewModel.MenuViewModel;
import utils.IJSONUploader;
import utils.JSONUpload;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<MenuViewModel> {
    private List<Cuenta> cuentas = new ArrayList<>();

    public MenuWindow(WindowOwner owner, MenuViewModel menuViewModel) {
        super(owner, menuViewModel);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        this.setTitle("Bienvenido!");
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
            MenuViewModel menuViewModel = new MenuViewModel(new JSONUpload());
            cuentas = menuViewModel.cargarCuentas();
            //mostrarAlerta("Las cuentas se cargaron correctamente :D");
        } catch (org.json.simple.parser.ParseException e) {
            throw new UserException("Hubo un problema al cargar el archivo");
        }
    }

    /*private void mostrarAlerta(String mensaje) {
        AlertWindow dialog = new AlertWindow(getOwner(), new EmpresasViewModel(getModelObject().getCuentas()), mensaje);
        dialog.open();
    }*/

    private void buscarCuentas() {

        EmpresasViewModel empresaViewModel = new EmpresasViewModel(new JSONUpload());
        SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), empresaViewModel);
        dialog.open();
    }

    @Override
    protected void addActions(Panel arg0) {
    }

}