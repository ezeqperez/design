package vista;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.viewModel.AlertViewModel;
import modelo.viewModel.MetodologiaViewModel;
import org.uqbar.arena.widgets.*;
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
        new Label(mainPanel).setText("Ingrese el nombre de la metodologia");
        new TextBox(mainPanel).bindValueToProperty("nombre");
        new Button(mainPanel).setCaption("Guardar nombre")
                .onClick(this::guardarNombre);


        new Label(mainPanel).setText("Comparador por un numero");
        final Selector<Indicador> indicadorComparadoConNumero = new Selector<>(mainPanel);
        indicadorComparadoConNumero.bindValueToProperty("indicadorComparadoConNumero");
        indicadorComparadoConNumero.bindItemsToProperty("indicadores");
        final Selector<String> comparadorPorNumero = new Selector<>(mainPanel);
        comparadorPorNumero.bindValueToProperty("comparadorNumero");
        comparadorPorNumero.bindItemsToProperty("comparadores");
        new TextBox(mainPanel).bindValueToProperty("valorNumero");
        new Button(mainPanel).setCaption("Guardar comparador")
                .onClick(this::guardarComparadorPorIndicador);



        new Label(mainPanel).setText("Comparador de indicadores contra empresas");
        final Selector<Indicador> indicadorContraEmpesa = new Selector<>(mainPanel);
        indicadorContraEmpesa.bindValueToProperty("indicadorContraEmpresa");
        indicadorContraEmpesa.bindItemsToProperty("indicadores");
        final Selector<String> comparadorIndicadorContraEmpesa = new Selector<>(mainPanel);
        comparadorIndicadorContraEmpesa.bindValueToProperty("comparadorIndicadorConEmpresa");
        comparadorIndicadorContraEmpesa.bindItemsToProperty("comparadores");
        final Selector<Empresa> empresa = new Selector<>(mainPanel);
        empresa.bindValueToProperty("empresaContraIndicador");
        empresa.bindItemsToProperty("empresas");
        new Button(mainPanel).setCaption("Guardar comparador")
                .onClick(this::guardarIndicadorConEmpresa);



        new Label(mainPanel).setText("Comparador por Criterio");
        final Selector<String> criterio = new Selector<>(mainPanel);
        criterio.bindValueToProperty("criterio");
        criterio.bindItemsToProperty("criterios");
        final Selector<Indicador> indicadorCriterio = new Selector<>(mainPanel);
        indicadorCriterio.bindValueToProperty("indicadorCriterio");
        indicadorCriterio.bindItemsToProperty("indicadores");
        final Selector<String> comparadorConCriterio = new Selector<>(mainPanel);
        comparadorConCriterio.bindValueToProperty("comparadorCriterio");
        comparadorConCriterio.bindItemsToProperty("comparadores");
        new TextBox(mainPanel).bindValueToProperty("valorCriterio");
        new Button(mainPanel).setCaption("Guardar comparador")
                .onClick(this::guardarComparadorConCriterio);



        new Label(mainPanel).setText("Comparador por Crecimiento");
        final Selector<String> comportamiento = new Selector<>(mainPanel);
        comportamiento.bindValueToProperty("comportamiento");
        comportamiento.bindItemsToProperty("comportamientos");
        final Selector<Indicador> indicadorComportamiento = new Selector<>(mainPanel);
        indicadorComportamiento.bindValueToProperty("indicadorComportamiento");
        indicadorComportamiento.bindItemsToProperty("indicadores");
        final Selector<String> comparadorComportamiento = new Selector<>(mainPanel);
        comparadorComportamiento.bindValueToProperty("comparadorComportamiento");
        comparadorComportamiento.bindItemsToProperty("comparadores");
        new TextBox(mainPanel).bindValueToProperty("valorComportamiento");
        new Button(mainPanel).setCaption("Guardar comparador")
                .onClick(this::guardarComparadorCrecimiento);


        new Button(mainPanel).setCaption("Guardar Metodología").onClick(this::guardarMetodologia).disableOnError();
        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }

    private void guardarNombre() {
        getModelObject().guardarNombre();
        mostrarAlerta("Nombre cargado correctamente");
    }

    private void guardarComparadorCrecimiento() {
        getModelObject().setComparadorCrecimiento();
        cartelCargaOk();
    }

    private void guardarComparadorConCriterio() {
        getModelObject().setComparadoConCriterio();
        cartelCargaOk();
    }

    private void guardarIndicadorConEmpresa() {
        getModelObject().setIndicadorConEmpresa();
        cartelCargaOk();
    }

    private void guardarComparadorPorIndicador() {
        getModelObject().guardarComparadorPorIndicador();
        cartelCargaOk();
    }

    private void guardarMetodologia(){
        getModelObject().guardarMetodologia();
        mostrarAlerta("La Metodologia se cargo correctamente");
        this.close();
    }


    private void cartelCargaOk() {
        mostrarAlerta("Condicion cargada correctamente");
    }

    private void mostrarAlerta(String mensaje) {
        new AlertWindow(getOwner(), new AlertViewModel(mensaje)).open();
    }
}
