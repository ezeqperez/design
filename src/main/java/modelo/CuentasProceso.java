package modelo;


import java.util.List;

public class CuentasProceso {
    //Esta clase procesa las cuentas levantadas desde el archivo.

    CuentasUpload cuentasUpload;
    List<Cuenta> listaDeCuentas;


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
}
