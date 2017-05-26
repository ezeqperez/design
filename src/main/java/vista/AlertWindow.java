package vista;

import modelo.viewModel.AlertViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import modelo.viewModel.EmpresasViewModel;

@SuppressWarnings("serial")
public class AlertWindow extends Dialog<AlertViewModel> {

    public AlertWindow(WindowOwner owner, AlertViewModel model) {
        super(owner, model);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).bindValueToProperty("mensaje");
        new Button(mainPanel).setCaption("Aceptar").onClick(this::close);
    }

}
