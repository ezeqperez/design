package modelo;


import org.uqbar.commons.utils.Observable;

import java.util.List;
import java.util.stream.Collectors;

@Observable
public class CuentasProceso {
    //Esta clase procesa las cuentas levantadas desde el archivo.

    CuentasUpload cuentasUpload;
    List<Cuenta> listaDeCuentas;
    String periodo;

    public void cargarEmpresas(){
        Empresa empresa = new Empresa();
        try{
            empresa = cuentasUpload.procesarArchivo();
        }catch (Exception e){
            System.out.println("Salió mal, hay que logearlo, "+e);
        }
    }

    public void cargarCuentas(){
        try{
            listaDeCuentas.addAll(cuentasUpload.procesarArchivoCuenta());

        }catch (Exception e){
            System.out.println("Salió mal, hay que logearlo, "+e);
        }
    }

    public void buscarPorPeriodo(){
        List<Cuenta> result =listaDeCuentas.stream().filter(cuenta -> cuenta.getPeriodo().equals(this.periodo)).collect(Collectors.toList());
        System.out.println("asd");
    }




    //Getters y setters
    public CuentasUpload getCuentasUpload() {
        return cuentasUpload;
    }

    public void setCuentasUpload(CuentasUpload cuentasUpload) {
        this.cuentasUpload = cuentasUpload;
    }

    public List<Cuenta> getListaDeCuentas() {
        return listaDeCuentas;
    }

    public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
