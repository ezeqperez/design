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
        this.setTitle("Buscador de cuentas");
        Panel columnasPanel = new Panel(mainPanel);
        columnasPanel.setLayout(new ColumnLayout(2));

        new Label(mainPanel).setText("Filtrar por empresa");
        new TextBox(mainPanel).setWidth(50).bindValueToProperty("empresaFilter");

        new Label(mainPanel).setText("Filtrar por periodo");
        new TextBox(mainPanel).setWidth(50).bindValueToProperty("periodoFilter");

        new Button(mainPanel).setCaption("Buscar Cuentas").onClick(this::aplicarFiltros);

        Table<Cuenta> tabla = new Table<>(this, Cuenta.class);
        tabla.bindItemsToProperty("cuentasFiltradas");

        Column<Cuenta> empresaColumn = new Column<>(tabla);
        empresaColumn.setTitle("Empresa");
        empresaColumn.setFixedSize(40);
        empresaColumn.bindContentsToProperty("empresa");

        Column<Cuenta> cuentaColumn = new Column<>(tabla);
        cuentaColumn.setTitle("Cuenta");
        cuentaColumn.setFixedSize(40);
        cuentaColumn.bindContentsToProperty("cuenta");

        Column<Cuenta> periodoColumn = new Column<>(tabla);
        periodoColumn.setTitle("Periodo");
        periodoColumn.setFixedSize(40);
        periodoColumn.bindContentsToProperty("periodo");

        Column<Cuenta> montoColumn = new Column<>(tabla);
        montoColumn.setTitle("Monto");
        montoColumn.setFixedSize(40);
        montoColumn.bindContentsToProperty("monto");

        new Button(mainPanel).setCaption("Aceptar").onClick(this::close);

    }

    public void aplicarFiltros() {
        getModelObject().filtrarEmpresas();
    }
}
