package modelo.viewModel;

import org.uqbar.commons.utils.Observable;

@Observable
public class AlertViewModel {
    private String Mensaje;

    public AlertViewModel(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
