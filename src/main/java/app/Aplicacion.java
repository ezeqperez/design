package app;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import modelo.EmpresasViewModel;
import utils.JSONUpload;
import vista.MenuWindow;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        new Aplicacion().start();

    }

    @Override
    protected Window<?> createMainWindow() {


        EmpresasViewModel EmpresasViewModel = new EmpresasViewModel(new JSONUpload());
        return new MenuWindow(this, EmpresasViewModel);
    }

}

