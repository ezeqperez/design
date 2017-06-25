package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

import utils.Excepciones.ExcepcionFiltroViewModel;

public class Empresa {

    private String nombre;
    private List<Periodo> periodos;

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas(){
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        for (Periodo periodo : periodos) {
            cuentas.addAll(periodo.getCuentas());
        }
        return cuentas;
    }
    
    //???
    public void setPeriodos(List<Periodo> p){
    	this.periodos = p;
    }
    
//    public void setPeriodo(Periodo c){
//    	periodos.add(c);
//    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        
    public List<Cuenta> cuentasPorPeriodo (int periodo){
    	return periodos.stream()
    			.filter(unPeriodo -> unPeriodo.getPeriodo() == periodo)
    			.map(unPeriodo -> unPeriodo.getCuentas())
    			.findAny()
    			.orElse(null);
    }

    public List<Periodo> getPeriodos(){
    	return periodos;
    }
        
    public Periodo getPeriodo(int periodoFilter) {
        return periodos.stream()
        		.filter(periodo -> periodo.getPeriodo() == periodoFilter)
        		.findAny()
        		.orElseThrow(() -> new ExcepcionFiltroViewModel("No se encontro el periodo"));
    }
}
