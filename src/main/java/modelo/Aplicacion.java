package modelo;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import vista.MenuWindow;

import java.util.ArrayList;

public class Aplicacion extends Application {
	
	public static void main(String[] args) {
		new Aplicacion().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		CuentasViewModel cuentasViewModel = new CuentasViewModel();
		cuentasViewModel.setCuentasUpload(new CuentasUpload());
		cuentasViewModel.setListaDeCuentas(new ArrayList<Cuenta>());
		return new MenuWindow(this, cuentasViewModel);
	}

}
