package app;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import utils.Empresas.EmpresasUpload;
import modelo.viewModel.MenuViewModel;
import vista.MenuWindow;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        new Aplicacion().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        final MenuViewModel menuViewModel = new MenuViewModel(new EmpresasUpload());
        return new MenuWindow(this, menuViewModel);
    }
}

