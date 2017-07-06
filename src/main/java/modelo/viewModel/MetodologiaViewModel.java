package modelo.viewModel;

import modelo.dominio.builder.MetodologiaBuilder;
import org.uqbar.commons.utils.Observable;

@Observable
public class MetodologiaViewModel {
    MetodologiaBuilder builder;
    String nombre;
    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
    }
    public void guardarCondicion(){
        builder.setCondicionSuma();
    }
    public void guardarMetodologia(){
        builder.build(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
