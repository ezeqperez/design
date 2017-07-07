package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.builder.MetodologiaBuilder;
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
    private String comparadorIndicadores;

    private boolean tocarBoton;

    public MetodologiaViewModel(){
        builder = new MetodologiaBuilder();
        indicadores = MetodologiasMock.getIndicadores();
        empresas = MetodologiasMock.getEmpresas();//EmpresasRepository.getInstance().getEmpresas();
    }


    public void guardarMetodologia(){
        builder.build();
    }

    public void guardarNombre() {
        builder.setNombre(nombre);
    }
    public void setComparadoConCriterio() {
        builder.setCondicionConCriterio();
    }

    public void guardarComparadorPorIndicador() {
        builder.setCondicionNumero();
    }

    public void setIndicadorConEmpresa() {
        builder.setCondicionIndicadorEmpresa();
    }

    public void setComparadorCrecimiento() {
        builder.setCondicionCrecimiento();
    }

    public List<String> getCriterios(){
        final List<String> operadores = new ArrayList<>();
        operadores.add("Promedio");
        operadores.add("Mediana");
        operadores.add("Sumatoria");
        return operadores;
    }

    public List<String> getComportamientos(){
        final List<String> comportamientos = new ArrayList<>();
        comportamientos.add("Creciente");
        comportamientos.add("Decreciente");
        return comportamientos;
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

    public String getComparadorIndicadores() {
        return comparadorIndicadores;
    }

    public void setComparadorIndicadores(String comparadorIndicadores) {
        this.comparadorIndicadores = comparadorIndicadores;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public Indicador getIndicadorComparadoConNumero() {
        return builder.getIndicadorComparadoConNumero();
    }

    public void setIndicadorComparadoConNumero(Indicador indicadorComparadoConNumero) {
        builder.setIndicadorComparadoConNumero(indicadorComparadoConNumero);
    }

    public String getComparadorNumero() {
        return builder.getComparadorNumero();
    }

    public void setComparadorNumero(String comparadorNumero) {
        builder.setComparadorNumero(comparadorNumero);
    }

    public Integer getValorNumero() {
        return builder.getValorNumero();
    }

    public void setValorNumero(Integer valorNumero) {
        builder.setValorNumero(valorNumero);
    }

    public Indicador getIndicadorContraEmpresa() {
        return builder.getIndicadorContraEmpresa();
    }

    public void setIndicadorContraEmpresa(Indicador indicadorContraEmpresa) {
        builder.setIndicadorContraEmpresa(indicadorContraEmpresa);
    }

    public String getComparadorIndicadorConEmpresa() {
        return builder.getComparadorIndicadorConEmpresa();
    }

    public void setComparadorIndicadorConEmpresa(String comparadorIndicadorConEmpresa) {
        builder.setComparadorIndicadorConEmpresa(comparadorIndicadorConEmpresa);
    }

    public Empresa getEmpresaContraIndicador() {
        return builder.getEmpresaContraIndicador();
    }

    public void setEmpresaContraIndicador(Empresa empresaContraIndicador) {
        builder.setEmpresaContraIndicador(empresaContraIndicador);
    }

    public String getCriterio() {
        return builder.getCriterio();
    }

    public void setCriterio(String criterio) {
        builder.setCriterio(criterio);
    }

    public Indicador getIndicadorCriterio() {
        return builder.getIndicadorCriterio();
    }

    public void setIndicadorCriterio(Indicador indicadorCriterio) {
        builder.setIndicadorCriterio(indicadorCriterio);
    }

    public String getComparadorCriterio() {
        return builder.getComparadorCriterio();
    }

    public void setComparadorCriterio(String comparadorCriterio) {
        builder.setComparadorCriterio(comparadorCriterio);
    }

    public Integer getValorCriterio() {
        return builder.getValorCriterio();
    }

    public void setValorCriterio(Integer valorCriterio) {
        builder.setValorCriterio(valorCriterio);
    }

    public String getComportamiento() {
        return builder.getComportamiento();
    }

    public void setComportamiento(String comportamiento) {
        builder.setComportamiento(comportamiento);
    }

    public Indicador getIndicadorComportamiento() {
        return builder.getIndicadorComportamiento();
    }

    public void setIndicadorComportamiento(Indicador indicadorComportamiento) {
        builder.setIndicadorComportamiento(indicadorComportamiento);
    }

    public String getComparadorComportamiento() {
        return builder.getComparadorComportamiento();
    }

    public void setComparadorComportamiento(String comparadorComportamiento) {
        builder.setComparadorComportamiento(comparadorComportamiento);
    }

    public Integer getValorComportamiento() {
        return builder.getValorComportamiento();
    }

    public void setValorComportamiento(Integer valorComportamiento) {
        builder.setValorComportamiento(valorComportamiento);
    }

}
