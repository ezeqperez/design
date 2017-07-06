package vista;

import modelo.viewModel.*;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<MenuViewModel> {

    public MenuWindow(WindowOwner owner, MenuViewModel menuViewModel) {
        super(owner, menuViewModel);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        setTitle("Bienvenido!");
        final Panel columnasPanel = new Panel(mainPanel);
        columnasPanel.setLayout(new ColumnLayout(2));

        new Button(columnasPanel).setCaption("Cargar empresas").onClick(this::cargarEmpresas);

        new Button(columnasPanel).setCaption("Consultar cuentas").onClick(this::buscarCuentas);

        new Button(columnasPanel).setCaption("Cargar indicadores").onClick(this::cargarIndicadores);

        new Button(columnasPanel).setCaption("Consultar indicadores").onClick(this::buscarIndicadores);

        new Button(columnasPanel).setCaption("Cargar metodologias").onClick(this::cargarMetodologias);

        new Button(columnasPanel).setCaption("Aplicar metodologias").onClick(this::aplicarMetodologias);

        new FileSelector(mainPanel)
                .setCaption("Buscar Archivo")
                .bindValueToProperty("ruta");
        new Label(mainPanel).bindValueToProperty("ruta");
    }

    private void cargarMetodologias(){
        final MetodologiaViewModel metodologiaViewModel = new MetodologiaViewModel();
        final MetogologiaWindow form = new MetogologiaWindow(this, metodologiaViewModel);
        form.open();
    }

    private void aplicarMetodologias(){
        final AplicarMetodologiaViewModel aplicarMetodologiaViewModel = new AplicarMetodologiaViewModel();
        final AplicarMetodologiaWindow form = new AplicarMetodologiaWindow(this, aplicarMetodologiaViewModel);
        form.open();
    }

    private void buscarIndicadores() {
    	final SearchIndicadoresViewModel indicadoresViewModel = new SearchIndicadoresViewModel();
        final SearchIndicadoresWindow searchIndicadoresWindow = new SearchIndicadoresWindow(this, indicadoresViewModel);
        searchIndicadoresWindow.open();
    }

    private void cargarIndicadores() {
        IndicadorViewModel indicadorViewModel = new IndicadorViewModel();
        final IndicadorWindow indicadorWindow = new IndicadorWindow(getOwner(), indicadorViewModel);
        indicadorWindow.open();
    }

    private void cargarEmpresas() {
        try {
            getModelObject().cargarEmpresas();
            mostrarAlerta("Los empresas se cargaron correctamente :D");
        }catch(final Exception e) {
            new AlertWindow(getOwner(), new AlertViewModel("Hubo un problema al cargar las empresas."));
        }
    }

    private void mostrarAlerta(String mensaje) {
        new AlertWindow(getOwner(), new AlertViewModel(mensaje)).open();
    }

    private void buscarCuentas() {
        final EmpresasViewModel empresaViewModel = new EmpresasViewModel(getModelObject().getRepoEmpresas());
        final SearchCuentasWindow dialog = new SearchCuentasWindow(getOwner(), empresaViewModel);
        dialog.open();
    }

    @Override
    protected void addActions(Panel arg0) {
    }

}