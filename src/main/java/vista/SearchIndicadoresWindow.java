package vista;

import modelo.dominio.Indicador;
import modelo.viewModel.SearchIndicadoresViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
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
        final Selector<Indicador> selector = new Selector<>(mainPanel);
        selector.allowNull(false);
        selector.bindValueToProperty("nombreIndicador");
        selector.bindItemsToProperty("indicadoresPorNombre");
        //esta mal el binding de formula y tdvia no decidi quien va a concocer al repo de indicadores
        new Label(mainPanel).bindValueToProperty("formula");

        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }
}
