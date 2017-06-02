package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.uqbar.commons.model.UserException;

import modelo.dominio.Empresa;
import modelo.repositorios.EmpresasRepository;
import modelo.viewModel.EmpresasViewModel;
import utils.Empresas.EmpresasUpload;

public class EmpresasViewModelTest {
	
	EmpresasUpload empresasUpload;
	List<Empresa> empresasCargadas = new ArrayList<Empresa>();
	EmpresasRepository empresasRepo = new EmpresasRepository();
	EmpresasViewModel viewModel;
	
	@Rule
    public ExpectedException expecterEx = ExpectedException.none();

    @Before
    public void iniciar(){
    	empresasUpload = new EmpresasUpload();
    	empresasCargadas = empresasUpload.procesarArchivo("src/test/resources/test.json");
    	empresasRepo.agregarEmpresas(empresasCargadas);
    	viewModel = new EmpresasViewModel(empresasRepo);
    }
    
    @Test
    public void CargaLasEmpresasEnElViewModel() throws org.json.simple.parser.ParseException{     	
    	Assert.assertEquals(viewModel.getRepoEmpresas().getEmpresas().size(), 2);
    }
    
    @Test
    public void Carga2VecesLasEmpresasEnElViewModel() throws org.json.simple.parser.ParseException{    	
    	empresasRepo.agregarEmpresas(empresasCargadas);    	
    	Assert.assertEquals(viewModel.getRepoEmpresas().getEmpresas().size(), 4);
    }
    
    @Test
    public void filtrarUnaEmpresa() {
    	int anio = 2016;
        viewModel.setPeriodoFilter(anio);
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
        Assert.assertEquals(viewModel.getCuentasFiltradas().size(), 1);
    }
    
    @Test
    public void sinPeriodoSeteadoRompe() {  
    	expecterEx.expect(NullPointerException.class);
        viewModel.setEmpresaFilter("Facebook");
        viewModel.filtrarCuentas();
    }
    
    @Test
    public void laBusquedaNoRetornaNada() { 
    	expecterEx.expect(NullPointerException.class);
    	int anio = 2000;
        viewModel.setEmpresaFilter("Facebook");
        viewModel.setPeriodoFilter(anio);
        viewModel.filtrarCuentas();        
    }
}
