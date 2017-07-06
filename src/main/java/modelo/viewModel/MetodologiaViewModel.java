package modelo.viewModel;

import modelo.dominio.Metodologia;
import modelo.dominio.builder.MetodologiaBuilder;

public class MetodologiaViewModel {
    MetodologiaBuilder builder;
    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
    }
    public void guardarCondicion(){
        builder.setCondicionSuma();
    }
    public void guardarMetodologia(){
        builder.build();
    }
}
