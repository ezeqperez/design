import modelo.Cuenta;
import modelo.CuentasViewModel;
import org.junit.Assert;
import org.junit.Test;
import utils.CuentasUpload;

import java.util.ArrayList;


public class CuentasViewModelTest {
    Fixture fixture = new Fixture();
    @Test
    public void testProcesarTresCuentas(){
        CuentasViewModel viewModel = new CuentasViewModel(fixture.uploadDeTresCuentas(), new ArrayList<Cuenta>());

        viewModel.cargarCuentas();
        Assert.assertEquals(viewModel.getListaDeCuentas().size(), 3);
    }

    @Test
    public void seCarganOkLasCuentas(){
        CuentasViewModel viewModel = new CuentasViewModel(fixture.uploadDeTresCuentas(), new ArrayList<Cuenta>());

        viewModel.cargarCuentas();
        Assert.assertTrue(viewModel.getListaDeCuentas().containsAll(fixture.tresCuentas()));
    }



    @Test
    public void filtrarUnaEmpresa(){
        CuentasViewModel viewModel = new CuentasViewModel(new CuentasUpload(), fixture.tresCuentas());

        viewModel.setPeriodoFilter("2016");
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas().size(),1);
    }


    @Test(expected = NullPointerException.class)
    public void sinPeriodoSeteadoRompe(){
        CuentasViewModel viewModel = new CuentasViewModel(new CuentasUpload(), fixture.tresCuentas());

        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
    }
}
