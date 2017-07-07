package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.builder.MetodologiaBuilder;
import modelo.repositorios.EmpresasRepository;
import modelo.repositorios.IndicadoresRepository;
import org.uqbar.commons.utils.Observable;
import vista.MetodologiasMock.MetodologiasMock;

import java.util.ArrayList;
import java.util.List;

@Observable
public class MetodologiaViewModel {
    private MetodologiaBuilder builder;
    private List<Indicador> indicadores;
    private List<Empresa> empresas;
    private String nombre;

    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
        indicadores = IndicadoresRepository.getInstance().getIndicadores();
        empresas = MetodologiasMock.getEmpresas();//EmpresasRepository.getInstance().getEmpresas();
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

    public String getNombre(){return nombre;}

    public List<String> getComparadores(){
        final List<String> comparadores = new ArrayList<>();
        comparadores.add("<");
        comparadores.add(">");
        return comparadores;
    }

    public List<Empresa> getEmpresas(){
        return empresas;
    }

    public void setIndicadorUno(Indicador indicador){

    }

    public Indicador getIndicadorUno(){
        Indicador indicador = new Indicador();
        indicador.setNombre("IndicadorPrueba");
        return indicador;
    }

    public void setComparadorUno(String comparador){

    }

    public String getComparadorUno(){
        return "<";
    }

    public Integer getValorUno(){
        return 0; //aca se lo tiene que pedir al builder..
    }

    public void setValorUno(Integer valor){

    }

    public void setAniosUno(Integer anios){}

    public void setIndicadorDos(Indicador indicador){

    }

    public void setComparadorDos(String comparador){

    }

    public String getComparadorDos(){
        return "<";
    }

    public void setEmpresaDos(Empresa empresa){}

    public Empresa getEmpresaDos(){
        return MetodologiasMock.getEmpresas().get(0);
    }

    public List<String> getOperadoresTres(){
        final List<String> operadores = new ArrayList<>();
        operadores.add("Promedio");
        operadores.add("Mediana");
        operadores.add("Sumatoria");
        return operadores;
    }

    public void setOperadorTres(String operador){}

    public String getOperadorTres(){
        return "Mediana";
    }

    public void setIndicadorTres(Indicador indicador){

    }

    public Indicador getIndicadorTres(){
        Indicador indicador = new Indicador();
        indicador.setNombre("IndicadorPrueba");
        return indicador;
    }

    public void setComparadorTres(String comparador){

    }

    public String getComparadorTres(){
        return "<";
    }

    public Integer getValorTres(){
        return 0; //aca se lo tiene que pedir al builder..
    }

    public void setValorTres(Integer valor){

    }

    public void setIndicadorCuatro(Indicador indicador){

    }

    public Indicador getIndicadorCuatro(){
        Indicador indicador = new Indicador();
        indicador.setNombre("IndicadorPrueba");
        return indicador;
    }

    public List<String> getComportamientos(){
        final List<String> comportamientos = new ArrayList<>();
        comportamientos.add("Creciente");
        comportamientos.add("Decreciente");
        return comportamientos;
    }

    public void setComportamientoCuatro(String comportamiento){}

    public String getComportamientoCuatro(){
        return "Creciente"; //aca tmb se lo deberia pedir al builder
    }

    public void setPeriodoCuatro(Integer periodo){}

    public Integer getPeriodoCuatro(){
        return 1900; //aca se lo tiene que pedir al builder..
    }

}
