package modelo;

import java.util.List;

/**
 * Created by feder on 14/05/2017.
 */
public class Empresa {

    private String nombre;
    private List <Periodo> periodos;

    public String getNombre() {
        return nombre;
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





}
