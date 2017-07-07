package modelo.dominio.builder;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.Metodologia;
import modelo.dominio.operandos.condiciones.*;
import modelo.repositorios.MetodologiasRepository;
import org.uqbar.commons.model.UserException;

import java.util.ArrayList;
import java.util.List;

public class MetodologiaBuilder {
    private List<Condicion> condiciones = new ArrayList<>();
    private String nombre;
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


    public void setCondicionNumero(){
        verificarValoresNumero();
        CondicionNumerica condicionNumero = new CondicionNumerica();
        condicionNumero.setIndicador(indicadorComparadoConNumero);
        condicionNumero.setComparador(comparadorNumero);
        condicionNumero.setValor(valorNumero);
        condiciones.add(condicionNumero);
    }

    private void verificarValoresNumero() throws UserException {
        if(indicadorComparadoConNumero==null || comparadorNumero == null || valorNumero== null){
            datosMalCargados();
        }
    }
    public void datosMalCargados(){
        throw new UserException("Verifique los datos ingresados");
    }

    public void setCondicionIndicadorEmpresa() {
        verificarValoresEmpresa();
        CondicionIndicadorConEmpresa condicionEmpresa = new CondicionIndicadorConEmpresa();
        condicionEmpresa.setIndicador(indicadorContraEmpresa);
        condicionEmpresa.setComparador(comparadorIndicadorConEmpresa);
        condicionEmpresa.setEmpresa(empresaContraIndicador);
        condiciones.add(condicionEmpresa);
    }

    private void verificarValoresEmpresa() {
        if(indicadorContraEmpresa==null||comparadorIndicadorConEmpresa==null||empresaContraIndicador==null){
            datosMalCargados();
        }
    }

    public void setCondicionConCriterio() {
        verificarValoresCriterio();
        CondicionCriterio condicionCriterio = new CondicionCriterio();
        condicionCriterio.setCriterio(criterio);
        condicionCriterio.setIndicador(indicadorCriterio);
        condicionCriterio.setComparador(comparadorCriterio);
        condicionCriterio.setValor(valorCriterio);
        condiciones.add(condicionCriterio);
    }

    private void verificarValoresCriterio() {
        if(criterio==null||indicadorCriterio==null||comparadorCriterio==null||valorCriterio==null){
            datosMalCargados();
        }
    }

    public void setCondicionCrecimiento() {
        verificarValoresCrecimiento();
        CondicionCrecimiento condicionCrecimiento = new CondicionCrecimiento();
        condicionCrecimiento.setCrecimiento(comportamiento);
        condicionCrecimiento.setIndicador(indicadorComportamiento);
        condicionCrecimiento.setComparador(comparadorComportamiento);
        condicionCrecimiento.setValor(valorComportamiento);
        condiciones.add(condicionCrecimiento);
    }

    private void verificarValoresCrecimiento() {
        if(comportamiento==null||indicadorComportamiento==null||comparadorComportamiento==null||valorComportamiento==null){
            datosMalCargados();
        }
    }

    public void build(){
        verificarCondiciones();
        verificarNombre();
        Metodologia metodologia = new Metodologia();
        metodologia.setNombre(nombre);
        metodologia.setCondiciones(condiciones);
        MetodologiasRepository.getInstance().insert(metodologia);
    }

    private void verificarNombre() {
        if(nombre==null){
            throw new UserException("Elija un nombre para su metodologia");
        }
    }

    private void verificarCondiciones() {
        if(condiciones.size()<1){
            throw new UserException("Primero realice la carga de alguna condicion");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(List<Condicion> condiciones) {
        this.condiciones = condiciones;
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
}
