package vista;

import modelo.dominio.Cuenta;
import modelo.dominio.Indicador;
import modelo.viewModel.SearchIndicadoresViewModel;
import utils.Indicadores.IndicadorAplicado;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class SearchIndicadoresWindow extends SimpleWindow<SearchIndicadoresViewModel>{

    public SearchIndicadoresWindow(WindowOwner parent, SearchIndicadoresViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {


        new Label(mainPanel).setText("Seleccione el Indicador:");
        
       /* 
        final Selector<Indicador> selector = new Selector<>(mainPanel);
        selector.allowNull(false);
        selector.bindValueToProperty("nombreIndicador");
        selector.bindItemsToProperty("indicadoresPorNombre");
        //esta mal el binding de formula y tdvia no decidi quien va a concocer al repo de indicadores
        new Label(mainPanel).bindValueToProperty("formula");
        */
        
        
        Table<IndicadorAplicado> tabla = new Table<>(this, IndicadorAplicado.class);
        tabla.bindItemsToProperty("indicadoresAplicados");

        Column<IndicadorAplicado> empresaColum = new Column<>(tabla);
        empresaColum.setTitle("Cuenta");
        empresaColum.setFixedSize(40);
        empresaColum.bindContentsToProperty("nombreEmpresa");

        Column<IndicadorAplicado> anioColum = new Column<>(tabla);
        anioColum.setTitle("Periodo");
        anioColum.setFixedSize(40);
        anioColum.bindContentsToProperty("anioPeriodo");
        
        Column<IndicadorAplicado> indicadorColum = new Column<>(tabla);
        indicadorColum.setTitle("Nombre del Indicador");
        indicadorColum.setFixedSize(40);
        indicadorColum.bindContentsToProperty("nombreIndicador");
        
        Column<IndicadorAplicado> montoColumn = new Column<>(tabla);
        montoColumn.setTitle("Monto");
        montoColumn.setFixedSize(40);
        montoColumn.bindContentsToProperty("valor");


        new Button(mainPanel).setCaption("Volver").onClick(this::close);
        new Button(mainPanel).setCaption("Cargar").onClick(this::cargarIndicadores);
    }
    
    public void cargarIndicadores() {
        getModelObject().cargadIndicadores();
    }
}
