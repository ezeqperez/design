package vista;

import modelo.dominio.Empresa;
import modelo.dominio.Metodologia;
import modelo.viewModel.AplicarMetodologiaViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class AplicarMetodologiaWindow extends SimpleWindow<AplicarMetodologiaViewModel>{

    public AplicarMetodologiaWindow(WindowOwner parent, AplicarMetodologiaViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {

    }

    @Override
    protected void createFormPanel(Panel mainPanel) {

        //En lugar de mostrar metodologias y empresas, ver este link : http://arena.uqbar-project.org/documentation/bindings/adapters.html

 //       final Selector<Metodologia> selector = new Selector<>(mainPanel);
   //     ///selector.allowNull(false);
     //   selector.bindValueToProperty("metodologia");
       // selector.bindItemsToProperty("metodologias");

        new Button(mainPanel).setCaption("Aplicar Metodología").onClick(this::aplicarMetodologia);

        final Table<Empresa> tabla = new Table<>(this, Empresa.class);
        tabla.bindItemsToProperty("empresasFiltradas");

        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }

    private void aplicarMetodologia(){
        getModelObject().aplicarMetodologia();
    }

}
