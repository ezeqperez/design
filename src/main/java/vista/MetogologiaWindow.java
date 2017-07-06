package vista;

import modelo.viewModel.MetodologiaViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public class MetogologiaWindow extends SimpleWindow<MetodologiaViewModel> {

    public MetogologiaWindow(WindowOwner parent, MetodologiaViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {

    }

    @Override
    protected void createFormPanel(Panel mainPanel) {

        //crear tipo 4 subPaneles, uno por cada tipo de Condicion
        //Tmb faltan clas 4 clases de condiciones (una por cada tipo), ya esta creada la interfaz correspondiente
        //Y por ultimo, falta el builder de una Metodologia, pero mepa que es cuestion de los otros tres..
        //Y por ultimo bis, faltan los test, pero no se si son necesarios para esta parte.. va a estar mockeado
        //Y por ultimo bis bis, falta generar una abstraccion para no repetir codigo en las vistas que tengan tablas
        new Button(mainPanel).setCaption("Agregar Condicion").onClick(this::guardarCondicion);
        new Button(mainPanel).setCaption("Guardar").onClick(this::guardarMetodologia);
        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }


    private void guardarCondicion(){
        getModelObject().guardarCondicion();
    }

    private void guardarMetodologia(){
        getModelObject().guardarMetodologia();
    }
}
