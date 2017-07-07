package vista;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.viewModel.AlertViewModel;
import modelo.viewModel.MetodologiaViewModel;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

public class MetogologiaWindow extends SimpleWindow<MetodologiaViewModel> {

    public MetogologiaWindow(WindowOwner parent, MetodologiaViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {

    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).setText("Ingrese el nombre de la metodologia");

        new TextBox(mainPanel).bindValueToProperty("nombre");

        final Panel condicionUno = new Panel(mainPanel);

        //final Selector<Indicador> selectorIndicadorUno = new Selector<>(condicionUno);
        //selectorIndicadorUno.bindValueToProperty("indicadorUno");
        //selectorIndicadorUno.bindItemsToProperty("indicadores");

        final Selector<String> comparadorUno = new Selector<>(condicionUno);
        comparadorUno.bindValueToProperty("comparadorUno");
        comparadorUno.bindItemsToProperty("comparadores");

        new TextBox(condicionUno).bindValueToProperty("valorUno");

//        new Spinner(condicionUno).setWidth(200).bindValueToProperty("aniosUno");

        final Panel condicionDos = new Panel(mainPanel);

        //final Selector<Indicador> selectorIndicadorDos = new Selector<>(condicionDos);
        //selectorIndicadorDos.bindValueToProperty("indicadorDos");
        //selectorIndicadorDos.bindItemsToProperty("indicadores");

        final Selector<String> comparadorDos = new Selector<>(condicionDos);
        comparadorDos.bindValueToProperty("comparadorDos");
        comparadorDos.bindItemsToProperty("comparadores");

        final Selector<Empresa> empresas = new Selector<>(condicionDos);
        empresas.bindValueToProperty("empresaDos");
        empresas.bindItemsToProperty("empresas");

        final Panel condicionTres = new Panel(mainPanel);

        final Selector<String> selectorOperadorTres = new Selector<>(condicionTres);
        selectorOperadorTres.bindValueToProperty("operadorTres");
        selectorOperadorTres.bindItemsToProperty("operadoresTres");

        //final Selector<Indicador> selectorIndicadorTres = new Selector<>(condicionTres);
        //selectorIndicadorTres.bindValueToProperty("indicadorTres");
        //selectorIndicadorTres.bindItemsToProperty("indicadores");

        final Selector<String> comparadorTres = new Selector<>(condicionTres);
        comparadorTres.bindValueToProperty("comparadorTres");
        comparadorTres.bindItemsToProperty("comparadores");

        new TextBox(condicionTres).bindValueToProperty("valorTres");

        final Panel condicionCuatro = new Panel(mainPanel);

        //final Selector<Indicador> selectorIndicadorCuatro = new Selector<>(condicionCuatro);
        //selectorIndicadorCuatro.bindValueToProperty("indicadorCuatro");
        //selectorIndicadorCuatro.bindItemsToProperty("indicadores");

        final Selector<String> selectorComportamientoCuatro = new Selector<>(condicionCuatro);
        selectorComportamientoCuatro.bindValueToProperty("comportamientoCuatro");
        selectorComportamientoCuatro.bindItemsToProperty("comportamientos");

        new TextBox(condicionCuatro).bindValueToProperty("periodoCuatro");

        //Y por ultimo bis, faltan los test, pero no se si son necesarios para esta parte.. va a estar mockeado
        //Y por ultimo bis bis, falta generar una abstraccion para no repetir codigo en las vistas que tengan tablas

//        new Button(mainPanel).setCaption("Agregar Condicion")
//                .onClick(this::guardarCondicion);

        new Button(mainPanel).setCaption("Guardar").onClick(this::guardarMetodologia);
        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }

    private void guardarCondicion(){
        getModelObject().guardarCondicion();
    }

    private void guardarMetodologia(){
        getModelObject().guardarMetodologia();
        mostrarAlerta("La Metodologia se cargo correctamente");
        this.close();
    }

    //todo: Alerta, codigo repetido con las otras ventanas, no pueden compartir todas una misma interfaz?  -Juli: qué flasheas?!
    private void mostrarAlerta(String mensaje) {
        new AlertWindow(getOwner(), new AlertViewModel(mensaje)).open();
    }
}
