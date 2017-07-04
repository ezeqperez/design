package test.Empresas;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import utils.Excepciones.*;
import modelo.dominio.Empresa;
import modelo.repositorios.EmpresasRepository;
import modelo.viewModel.EmpresasViewModel;
import utils.Empresas.EmpresasUpload;

public class EmpresasViewModelTest {	
	
	EmpresasUpload empresasUpload = null;
	List<Empresa> empresasCargadas = new ArrayList<>();
	EmpresasRepository repo = EmpresasRepository.getInstance();
	EmpresasViewModel viewModel = null;
	
	@Rule
    public ExpectedException expecterEx = ExpectedException.none();

    @Before
    public void iniciar(){
    	empresasUpload = new EmpresasUpload();
    	empresasCargadas = empresasUpload.procesarArchivo("/home/retconadmin/WorkspaceFacu/2017-vn-group-01/src/test/resources/test.json");
    	repo.agregarEmpresas(empresasCargadas);
    	viewModel = new EmpresasViewModel(repo);
    }
    
    @Test
    public void CargaLasEmpresasEnElViewModel(){     	
	    Assert.assertEquals(2, viewModel.getRepoEmpresas().getEmpresas().size());
    }
    
    @Test
    public void Carga2VecesLasEmpresasEnElViewModel(){    	
    	repo.agregarEmpresas(empresasCargadas);    	
    	Assert.assertEquals(4, viewModel.getRepoEmpresas().getEmpresas().size());
    }
    
    @Test
    public void filtrarUnaEmpresaPorAño() {
        viewModel.setPeriodoFilter(2016);
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas().size(), 1);
    }
    
    @Test
    public void sinPeriodoSeteadoRompe() {  
    	expecterEx.expect(ExcepcionFiltroViewModel.class);
        expecterEx.expectMessage("No se encontro el periodo");
    	viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        
    }
    
    @Test
    public void laBusquedaNoRetornaNada() { 
    	expecterEx.expect(ExcepcionFiltroViewModel.class);
        expecterEx.expectMessage("No se encontro el periodo");
        viewModel.setEmpresaFilter("Facebook");
        viewModel.setPeriodoFilter(2000);
        viewModel.filtrarCuentas();        
    }
    
    @After
    public void vaciarRepo(){
    	repo.vaciar();
    }
    
}
