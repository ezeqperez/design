package vista;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import modelo.dominio.Cuenta;
import modelo.viewModel.EmpresasViewModel;

@SuppressWarnings("serial")
public class SearchCuentasWindow extends SimpleWindow<EmpresasViewModel> {

    public SearchCuentasWindow(WindowOwner parent, EmpresasViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        setTitle("Buscador de cuentas");
        final Panel columnasPanel = new Panel(mainPanel);
        columnasPanel.setLayout(new ColumnLayout(2));

        new Label(mainPanel).setText("Filtrar por empresa");
        new TextBox(mainPanel).setWidth(50).bindValueToProperty("empresaFilter");

        new Label(mainPanel).setText("Filtrar por periodo");
        new TextBox(mainPanel).setWidth(50).bindValueToProperty("periodoFilter");

        new Button(mainPanel).setCaption("Buscar Cuentas").onClick(this::aplicarFiltros);

        final Table<Cuenta> tabla = new Table<>(this, Cuenta.class);
        tabla.bindItemsToProperty("cuentasFiltradas");

        final Column<Cuenta> cuentaColumn = new Column<>(tabla);
        cuentaColumn.setTitle("Cuenta");
        cuentaColumn.setFixedSize(40);
        cuentaColumn.bindContentsToProperty("nombre");

        final Column<Cuenta> montoColumn = new Column<>(tabla);
        montoColumn.setTitle("Monto");
        montoColumn.setFixedSize(40);
        montoColumn.bindContentsToProperty("monto");

        new Button(mainPanel).setCaption("Aceptar").onClick(this::close);

    }

    public void aplicarFiltros() {
        getModelObject().filtrarCuentas();
    }
}
