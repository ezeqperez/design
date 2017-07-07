package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.builder.MetodologiaBuilder;
import modelo.repositorios.EmpresasRepository;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class MetodologiaViewModel {
    private MetodologiaBuilder builder;
    private List<Indicador> indicadores;
    private List<Empresa> empresas;

    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
        indicadores = IndicadoresRepository.getInstance().getIndicadores();
        empresas = EmpresasRepository.getInstance().getEmpresas();
    }
    public void guardarCondicion(){
        builder.setCondicionSuma();
    }

    public void guardarMetodologia(){
        builder.build();
    }

    public void setNombre(String nombre) {
        builder.setNombre(nombre);
    }

    public List<String> getComparadores(){
        final List<String> comparadores = new ArrayList<>();
        comparadores.add("<");
        comparadores.add(">");
        return comparadores;
    }

    public void setIndicadorUno(Indicador indicador){

    }
    public void setComparadorUno(String comparador){

    }
    public void sestValorUno(Integer valor){}
    public void setAniosUno(Integer anios){}

    public void setIndicadorDos(Indicador indicador){

    }

    public void setComparadorDos(String comparador){

    }

    public void setEmpresaDos(Empresa empresa){}

    public List<String> getOperadoresTres(){
        final List<String> operadores = new ArrayList<>();
        operadores.add("Promedio");
        operadores.add("Mediana");
        operadores.add("Sumatoria");
        return operadores;
    }

    public void setIndicadorTres(Indicador indicador){

    }

    public void setComparadorTres(String comparador){

    }

    public void setValorTres(Integer valor){

    }

    public void setIndicadorCuatro(Indicador indicador){

    }

    public List<String> getComportamientoCuatro(){
        final List<String> comportamientos = new ArrayList<>();
        comportamientos.add("Creciente");
        comportamientos.add("Decreciente");
        return comportamientos;
    }

    public void setComportamientoCuatro(String comportamiento){}

    public void setPeriodoCuatro(Integer periodo){}

}
