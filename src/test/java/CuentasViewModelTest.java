import modelo.Cuenta;
import modelo.CuentasViewModel;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.uqbar.commons.model.UserException;
import modelo.MenuViewModel;

import java.util.ArrayList;

public class CuentasViewModelTest {

    Fixture fixture = new Fixture();

    @Test
    public void testProcesarTresCuentas() throws ParseException {
        MenuViewModel menuViewModel = new MenuViewModel(fixture.uploadDeTresCuentas());
        menuViewModel.cargarCuentas();
        Assert.assertEquals(menuViewModel.getCuentas().size(), 3);
    }

    @Test
    public void seCarganOkLasCuentas() throws ParseException {
        MenuViewModel menuViewModel = new MenuViewModel(fixture.uploadDeTresCuentas());
        menuViewModel.cargarCuentas();
        Assert.assertTrue(menuViewModel.getCuentas().equals(fixture.tresCuentas()));
    }

    @Test
    public void cargaDosVecesOKLasCuentas() throws ParseException {
        MenuViewModel menuViewModel = new MenuViewModel(fixture.uploadDeTresCuentas());
        menuViewModel.cargarCuentas();
        menuViewModel.cargarCuentas();
        Assert.assertEquals(menuViewModel.getCuentas().size(), 6);
    }

    @Test
    public void filtrarUnaEmpresa() throws ParseException {
        MenuViewModel menuViewModel = new MenuViewModel(fixture.uploadDeTresCuentas());
        menuViewModel.cargarCuentas();
        CuentasViewModel viewModel = new CuentasViewModel(menuViewModel.getCuentas());
        viewModel.setCuentas(fixture.tresCuentas());

        viewModel.setPeriodoFilter("2016");
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas().size(), 1);
    }

    @Test(expected = UserException.class)
    public void sinPeriodoSeteadoRompe() throws ParseException {
        MenuViewModel menuViewModel = new MenuViewModel(fixture.uploadDeTresCuentas());
        menuViewModel.cargarCuentas();
        CuentasViewModel viewModel = new CuentasViewModel(menuViewModel.getCuentas());
        viewModel.setCuentas(fixture.tresCuentas());
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
    }

    @Test
    public void laBusquedaNoRetornaNada() throws ParseException {
        CuentasViewModel viewModel = new CuentasViewModel(fixture.tresCuentas());
        viewModel.setEmpresaFilter("Facebook");
        viewModel.setPeriodoFilter("2000");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas(), new ArrayList<Cuenta>());
    }
}
