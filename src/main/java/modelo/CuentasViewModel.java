package modelo;


import org.uqbar.commons.utils.Observable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class CuentasViewModel {
    //Esta clase procesa las cuentas que se cargan desde el archivo.

    CuentasUpload cuentasUpload;    //Dependencia
    List<Cuenta> listaDeCuentas;    //Total de cuentas procesadas
    List<Cuenta> cuentasFiltradas;  //Cuentas que cumplen el filtro de empresa y periodo
    //TODO: Las cuentas filtradas son las que se tienen que mostrar en una vista nueva

    String empresa;
    String periodo;

    //TODO: Ver como manejar las excepciones, si las arrojo, se me queja la vista

    public void cargarCuentas(){
        try{
            listaDeCuentas.addAll(cuentasUpload.procesarArchivo());
        }catch (Exception e){

        }
    }

    public void filtrarCuentas(){
        //TODO: Sacar el if, Gaston se va a enojar
        if(this.validarEmpresaYCuenta()) {
            cuentasFiltradas = listaDeCuentas.stream().filter(cuenta -> Objects.equals(cuenta.getPeriodo(),this.periodo) && Objects.equals(cuenta.getEmpresa(),this.empresa)).collect(Collectors.toList());
            System.out.println("asd");
        }else{
            //TODO: algun cartel que diga que estos campos no pueden estar vacios?
        }
    }

    private boolean validarEmpresaYCuenta(){
        //TODO: Feo feo, la idea es tirar una excepcion si esto no se cumple, y no hacer el if guarango de arriba
        //PERO NO SE COMO!!!!
        return !this.empresa.isEmpty() && !this.periodo.isEmpty();
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


}
