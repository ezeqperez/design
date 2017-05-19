package app;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import utils.CuentasUpload;
import modelo.MenuViewModel;
import vista.MenuWindow;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        new Aplicacion().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        final MenuViewModel menuViewModel = new MenuViewModel(new CuentasUpload());
        return new MenuWindow(this, menuViewModel);
    }
}
