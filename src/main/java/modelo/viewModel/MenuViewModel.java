package modelo.viewModel;

import modelo.dominio.Cuenta;
import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.Periodo;
import modelo.repositorios.EmpresasRepository;
import modelo.repositorios.IndicadoresRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;
import utils.Empresas.EmpresasUploader;
import utils.Excepciones.ExcepcionParseo;
import utils.Empresas.EmpresasUpload;

@Observable
public class MenuViewModel {
    private EmpresasRepository repoEmpresas;
    private EmpresasUploader empresasUploader; // Dependencia
    private String ruta;  //Ruta donde se va a buscar el archivo a procesar
    private IndicadoresRepository repoIndicadores;

    public MenuViewModel(EmpresasUploader iJsonEmpresasUploader) {
        empresasUploader = iJsonEmpresasUploader;
        ruta = "src/test/resources/test.json"; //Comienza con una ruta por defecto
    }

    public void cargarEmpresas(){
    		final EmpresasUpload empresasUpload = new EmpresasUpload();
    		EmpresasRepository.getInstance().agregarEmpresas(empresasUpload.procesarArchivo(ruta));
    		//throw new ExcepcionParseo("El archivo no se pudo cargar, por favor verifique que el formato sea el correcto");
    		
//    		List<Cuenta> cuentas = new ArrayList<>();
//    		List<Cuenta> cuentas2 = new ArrayList<>();
//    		List<Cuenta> cuentas3 = new ArrayList<>();
//    		
//    		List<Periodo> periodos = new ArrayList<>();
//    		List<Periodo> periodos2 = new ArrayList<>();
//    		List<Periodo> periodos3 = new ArrayList<>();
//
//    		
//    		Empresa emp1 = new Empresa();
//    		Empresa emp2 = new Empresa();
//    		Empresa emp3 = new Empresa();
//    		Periodo periodo2017 = new Periodo();
//    		Periodo periodo2016 = new Periodo();
//    		Periodo periodo2014 = new Periodo();
//    		Cuenta ebidta = new Cuenta();
//    		Cuenta lala = new Cuenta();
//    		Cuenta lele = new Cuenta();
//    		BigDecimal bd = new BigDecimal(1.0);
//    		BigDecimal bd2 = new BigDecimal(2.0);
//    		BigDecimal bd3 = new BigDecimal(3.0);
//    		
//    		emp1.setNombre("emp1");
//    		emp2.setNombre("emp2");
//    		emp3.setNombre("emp3");
//   
//    		ebidta.setNombre("EBIDTA");
//    		lala.setNombre("LALA");
//    		lele.setNombre("LELE");
//    		ebidta.setMonto(bd);
//    		lala.setMonto(bd2);
//    		lele.setMonto(bd3);
//    		cuentas.add(ebidta);
//    		cuentas2.add(ebidta);
//    		cuentas2.add(lele);
//    		cuentas3.add(lele);
//    		
//    		periodo2017.setAnio(2017);
//    		periodo2016.setAnio(2016);
//    		periodo2014.setAnio(2014);
//    		periodo2017.setCuentas(cuentas);
//    		periodo2016.setCuentas(cuentas2);
//    		periodo2014.setCuentas(cuentas3);
//    		periodos.add(periodo2014);
//    		periodos2.add(periodo2016);
//    		periodos2.add(periodo2017);
//    		periodos3.add(periodo2017);
//
//    		emp1.setPeriodos(periodos);
//    		emp2.setPeriodos(periodos2);
//    		emp3.setPeriodos(periodos3);   	
//    		
//    		EmpresasRepository.getInstance().insert(emp1);
//    		EmpresasRepository.getInstance().insert(emp2);
//    		EmpresasRepository.getInstance().insert(emp3);

    		
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public EmpresasRepository getRepoEmpresas() {
        return repoEmpresas;
    }

    public void setRepoEmpresas(EmpresasRepository repoEmpresas) {
        this.repoEmpresas = repoEmpresas;
    }

    public EmpresasUploader getEmpresasUploader() {
        return empresasUploader;
    }

    public void setEmpresasUploader(EmpresasUploader iJsonEmpresasUploader) {
        empresasUploader = iJsonEmpresasUploader;
    }

    
    //TODO Todavia no usamos bien un repo creo
    //hay que probar si funciona bien usando el getInstance y esas cosas
    public IndicadoresRepository getRepoIndicadores(){
    	return repoIndicadores;
    }
    

}
