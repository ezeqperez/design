package vista;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.CuentasViewModel;

@SuppressWarnings("serial")
public class AlertWindow extends Dialog<CuentasViewModel> {

    private String mensaje;

    public AlertWindow(WindowOwner owner, CuentasViewModel model, String mensajeNuevo) {
        super(owner, model);
        this.setMensaje(mensajeNuevo);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).setText(mensaje);
        new Button(mainPanel).setCaption("Regresar").onClick(() -> this.close());
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
