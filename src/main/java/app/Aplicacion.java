package app;

import java.util.ArrayList;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import modelo.Cuenta;
import modelo.CuentasViewModel;
import utils.CuentasUpload;
import vista.MenuWindow;

public class Aplicacion extends Application {
	
	public static void main(String[] args) {
		new Aplicacion().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		
		CuentasViewModel cuentasViewModel = new CuentasViewModel(new CuentasUpload(), new ArrayList<Cuenta>());

		return new MenuWindow(this, cuentasViewModel);
	}

}
