import modelo.Cuenta;
import modelo.CuentasViewModel;
import org.junit.Assert;
import org.junit.Test;
import org.uqbar.commons.model.UserException;
import utils.CuentasUpload;

import java.util.ArrayList;


public class CuentasViewModelTest {

    Fixture fixture = new Fixture();


    @Test
    public void testProcesarTresCuentas() throws org.json.simple.parser.ParseException {
        CuentasViewModel viewModel = new CuentasViewModel(fixture.uploadDeTresCuentas());

        viewModel.cargarCuentas();
        Assert.assertEquals(viewModel.getListaDeCuentas().size(), 3);
    }

    @Test
    public void seCarganOkLasCuentas() throws org.json.simple.parser.ParseException {
        CuentasViewModel viewModel = new CuentasViewModel(fixture.uploadDeTresCuentas());

        viewModel.cargarCuentas();
        Assert.assertTrue(viewModel.getListaDeCuentas().equals(fixture.tresCuentas()));
    }

    @Test
    public void cargaDosVecesOKLasCuentas() throws org.json.simple.parser.ParseException {
        CuentasViewModel viewModel = new CuentasViewModel(fixture.uploadDeTresCuentas());
        viewModel.cargarCuentas();
        viewModel.cargarCuentas();
        Assert.assertEquals(viewModel.getListaDeCuentas().size(), 6);
    }


    @Test
    public void filtrarUnaEmpresa() {
        CuentasViewModel viewModel = new CuentasViewModel(new CuentasUpload());
        viewModel.setListaDeCuentas(fixture.tresCuentas());

        viewModel.setPeriodoFilter("2016");
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas().size(), 1);
    }


    @Test(expected = UserException.class)
    public void sinPeriodoSeteadoRompe() {
        CuentasViewModel viewModel = new CuentasViewModel(new CuentasUpload());
        viewModel.setListaDeCuentas(fixture.tresCuentas());
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
    }

    @Test
    public void laBusquedaNoRetornaNada() {
        CuentasViewModel viewModel = new CuentasViewModel(new CuentasUpload());
        viewModel.setListaDeCuentas(fixture.tresCuentas());
        viewModel.setEmpresaFilter("Facebook");
        viewModel.setPeriodoFilter("2000");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas(), new ArrayList<Cuenta>());
    }
}
