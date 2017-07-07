package vista;

import modelo.viewModel.AlertViewModel;
import modelo.viewModel.MetodologiaViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
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
        new Label(mainPanel).setText("Ingrese el nombre de la metodologia")
                .bindVisibleToProperty("primeraPantalla");

        //No se como esconder el textBox
        new TextBox(mainPanel).bindValueToProperty("nombre");
        new Button(mainPanel).setCaption("Guardar nombre").onClick(this::guardarNombre)
                .bindVisibleToProperty("primeraPantalla");;
        //crear tipo 4 subPaneles, uno por cada tipo de Condicion
        //Tmb faltan clas 4 clases de condiciones (una por cada tipo), ya esta creada la interfaz correspondiente
        //Y por ultimo, falta el builder de una Metodologia, pero mepa que es cuestion de los otros tres..
        //Y por ultimo bis, faltan los test, pero no se si son necesarios para esta parte.. va a estar mockeado
        //Y por ultimo bis bis, falta generar una abstraccion para no repetir codigo en las vistas que tengan tablas

        //Cuando sepamos como van a ser las condiciones, vemos de cargarlas OK
        new Button(mainPanel).setCaption("Agregar Condicion")
                .onClick(this::guardarCondicion)
                .bindVisibleToProperty("segundaPantalla");
        new Button(mainPanel).setCaption("Guardar").onClick(this::guardarMetodologia)
                .bindVisibleToProperty("segundaPantalla");
        new Button(mainPanel).setCaption("Volver").onClick(this::close)
                .bindVisibleToProperty("segundaPantalla");
    }

    private void guardarNombre() {
        getModelObject().guardarNombre();
    }

    private void guardarCondicion(){
        getModelObject().guardarCondicion();
    }

    private void guardarMetodologia(){
        getModelObject().guardarMetodologia();

        //Sese, claro
        mostrarAlerta("La Metodologia se cargo correctamente");
        this.close();
    }

    //todo: Alerta, codigo repetido con las otras ventanas, no pueden compartir todas una misma interfaz?
    private void mostrarAlerta(String mensaje) {
        new AlertWindow(getOwner(), new AlertViewModel(mensaje)).open();
    }
}
