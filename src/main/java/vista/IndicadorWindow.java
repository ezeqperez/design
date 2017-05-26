package vista;

import modelo.dominio.Indicador;
import modelo.viewModel.AlertViewModel;
import modelo.viewModel.IndicadorViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class IndicadorWindow extends SimpleWindow<IndicadorViewModel>{

    public IndicadorWindow(WindowOwner parent, IndicadorViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {

    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).setText("Ingrese el nombre del Indicador.");
        new TextBox(mainPanel).bindValueToProperty("nombre");
        new Label(mainPanel).setText("Ingrese la formula del Indicador.");
        new TextBox(mainPanel).bindValueToProperty("formula");
        new Button(mainPanel).setCaption("Guardar").onClick(this::guardarIndicador);
        new Button(mainPanel).setCaption("Volver").onClick(this::close);
    }

    private void guardarIndicador() {
        //guardar
        mostrarAlerta("El indicador se guardo correctamente.");
    }

    private void mostrarAlerta(String mensaje) {
        AlertWindow dialog = new AlertWindow(getOwner(), new AlertViewModel(mensaje));
        dialog.open();
    }
}
