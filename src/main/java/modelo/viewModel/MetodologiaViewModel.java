package modelo.viewModel;

import modelo.dominio.builder.MetodologiaBuilder;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class MetodologiaViewModel {
    MetodologiaBuilder builder;
    String nombre="";
    //La unica forma que pude modificar los botones en MetodologiaWindow
    Boolean primeraPantalla = true;
    Boolean segundaPantalla = false;

    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
    }
    public void guardarCondicion(){
        builder.setCondicionSuma();
    }

    public void guardarMetodologia(){
        builder.build();
    }

    public void guardarNombre() {
        //No me acuerdo como chequear por null
        if(nombre.isEmpty() || nombre == null){
            throw new UserException("Ingrese un nombre valido");
        }else{
            builder.setNombre(nombre);
            habilitarSegundaPantalla();
        }
    }

    private void habilitarSegundaPantalla() {
        primeraPantalla = false;
        segundaPantalla = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getSegundaPantalla() {
        return segundaPantalla;
    }

    public void setSegundaPantalla(Boolean segundaPantalla) {
        this.segundaPantalla = segundaPantalla;
    }

    public Boolean getPrimeraPantalla() {
        return primeraPantalla;
    }

    public void setPrimeraPantalla(Boolean primeraPantalla) {
        this.primeraPantalla = primeraPantalla;
    }
}
