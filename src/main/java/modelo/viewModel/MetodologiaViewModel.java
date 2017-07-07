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

    private Indicador indicadorComparadoConNumero;
    private String comparadorNumero;
    private Integer valorNumero;

    private Indicador indicadorContraEmpresa;
    private String comparadorIndicadorConEmpresa;
    private Empresa empresaContraIndicador;

    private String criterio;
    private Indicador indicadorCriterio;
    private String comparadorCriterio;
    private Integer valorCriterio;

    private String comportamiento;
    private Indicador indicadorComportamiento;
    private String comparadorComportamiento;
    private Integer valorComportamiento;

    private boolean verCrecimiento = true;
    private boolean verNumero = true;
    private boolean verEmpresa = true;
    private boolean VerCriterio = true;

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
        builder.setCondicionConCriterio(criterio, indicadorCriterio, comparadorCriterio, valorCriterio);
    }

    public void guardarComparadorPorIndicador() {
        builder.setCondicionNumero(indicadorComparadoConNumero, comparadorNumero, valorNumero);
        verNumero = false;
    }

    public void setIndicadorConEmpresa() {
        builder.setCondicionIndicadorEmpresa(indicadorContraEmpresa, comparadorIndicadorConEmpresa, empresaContraIndicador);
    }

    public void setComparadorCrecimiento() {
        builder.setCondicionCrecimiento(comportamiento, indicadorComportamiento, comparadorComportamiento, valorComportamiento);
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
        return indicadorComparadoConNumero;
    }

    public void setIndicadorComparadoConNumero(Indicador indicadorComparadoConNumero) {
        this.indicadorComparadoConNumero = indicadorComparadoConNumero;
    }

    public String getComparadorNumero() {
        return comparadorNumero;
    }

    public void setComparadorNumero(String comparadorNumero) {
        this.comparadorNumero = comparadorNumero;
    }

    public Integer getValorNumero() {
        return valorNumero;
    }

    public void setValorNumero(Integer valorNumero) {
        this.valorNumero = valorNumero;
    }

    public Indicador getIndicadorContraEmpresa() {
        return indicadorContraEmpresa;
    }

    public void setIndicadorContraEmpresa(Indicador indicadorContraEmpresa) {
        this.indicadorContraEmpresa = indicadorContraEmpresa;
    }

    public String getComparadorIndicadorConEmpresa() {
        return comparadorIndicadorConEmpresa;
    }

    public void setComparadorIndicadorConEmpresa(String comparadorIndicadorConEmpresa) {
        this.comparadorIndicadorConEmpresa = comparadorIndicadorConEmpresa;
    }

    public Empresa getEmpresaContraIndicador() {
        return empresaContraIndicador;
    }

    public void setEmpresaContraIndicador(Empresa empresaContraIndicador) {
        this.empresaContraIndicador = empresaContraIndicador;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Indicador getIndicadorCriterio() {
        return indicadorCriterio;
    }

    public void setIndicadorCriterio(Indicador indicadorCriterio) {
        this.indicadorCriterio = indicadorCriterio;
    }

    public String getComparadorCriterio() {
        return comparadorCriterio;
    }

    public void setComparadorCriterio(String comparadorCriterio) {
        this.comparadorCriterio = comparadorCriterio;
    }

    public Integer getValorCriterio() {
        return valorCriterio;
    }

    public void setValorCriterio(Integer valorCriterio) {
        this.valorCriterio = valorCriterio;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public Indicador getIndicadorComportamiento() {
        return indicadorComportamiento;
    }

    public void setIndicadorComportamiento(Indicador indicadorComportamiento) {
        this.indicadorComportamiento = indicadorComportamiento;
    }

    public String getComparadorComportamiento() {
        return comparadorComportamiento;
    }

    public void setComparadorComportamiento(String comparadorComportamiento) {
        this.comparadorComportamiento = comparadorComportamiento;
    }

    public Integer getValorComportamiento() {
        return valorComportamiento;
    }

    public void setValorComportamiento(Integer valorComportamiento) {
        this.valorComportamiento = valorComportamiento;
    }

    public boolean isVerCrecimiento() {
        return verCrecimiento;
    }

    public void setVerCrecimiento(boolean verCrecimiento) {
        this.verCrecimiento = verCrecimiento;
    }

    public boolean isVerNumero() {
        return verNumero;
    }

    public void setVerNumero(boolean verNumero) {
        this.verNumero = verNumero;
    }

    public boolean isVerEmpresa() {
        return verEmpresa;
    }

    public void setVerEmpresa(boolean verEmpresa) {
        this.verEmpresa = verEmpresa;
    }

    public boolean isVerCriterio() {
        return VerCriterio;
    }

    public void setVerCriterio(boolean verCriterio) {
        VerCriterio = verCriterio;
    }
}
