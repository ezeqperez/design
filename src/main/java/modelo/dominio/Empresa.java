package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> cuentasPorPeriodo (int periodo){
        for (Periodo p : periodos) {
            if (p.getPeriodo()==periodo){
                return p.getCuentas();
            }
        }
        return null;
    }


    public Periodo getPeriodo(int periodoFilter) {
        for (Periodo p : periodos) {
            if (p.getPeriodo()==periodoFilter){
                return p;
            }
        }
        return null;
    }
}
