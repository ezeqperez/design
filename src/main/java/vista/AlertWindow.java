package vista;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import modelo.viewModel.EmpresasViewModel;

@SuppressWarnings("serial")
public class AlertWindow extends Dialog<EmpresasViewModel> {

    private String mensaje;

    public AlertWindow(WindowOwner owner, EmpresasViewModel model, String mensajeNuevo) {
        super(owner, model);
        this.setMensaje(mensajeNuevo);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).setText(mensaje);
        new Button(mainPanel).setCaption("Aceptar").onClick(this::close);
    }

    public String getMensaje() {
        return mensaje;
    }

    private void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
