package modelo.dominio;

import modelo.dominio.Empresa;
import modelo.dominio.operaciones.Operacion;
import modelo.dominio.operandos.Operando;
import modelo.repositorios.EmpresasRepository;
import utils.Indicadores.IndicadorAplicado;

import org.uqbar.commons.utils.Observable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Observable
public class Indicador implements Operando, Serializable {

	private String nombre;
	private String formula;

	private Operando primerOperando;
	private Operando segundoOperando;
	private String simbolo; // Seguro vuele, va de momento
	private Operacion operacion;
	private IndicadorAplicado indicadorAplicado = new IndicadorAplicado();
	private  List<IndicadorAplicado> listaIndicadores;


	private boolean estado;

	private List<Operando> operandos = new ArrayList<Operando>(); // vamos a ver
																	// si
																	// conviene

	private static final long serialVersionUID = 1L;

	@Override
	public BigDecimal valor(Periodo periodo) {
		return operacion.operar(primerOperando.valor(periodo), segundoOperando.valor(periodo));
	}
	
	public List<IndicadorAplicado> getListaIndicadores() {
		return listaIndicadores;
	}
	
	public void setListaIndicadores(List<IndicadorAplicado> listaIndicadores) {
		this.listaIndicadores = listaIndicadores;
	}
	
	public void agregarIndicadorAplicado(IndicadorAplicado in){
		listaIndicadores.add(in);
	}

	public String getNombre() {
		return nombre;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Operando getPrimerOperando() {
		return primerOperando;
	}

	public void setPrimerOperando(Operando primerOperando) {
		this.primerOperando = primerOperando;
	}

	public Operando getSegundoOperando() {
		return segundoOperando;
	}

	public void setSegundoOperando(Operando segundoOperando) {
		this.segundoOperando = segundoOperando;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public List<Operando> getOperandos() {
		return operandos;
	}

	public void setOperandos(List<Operando> operandos) {
		this.operandos = operandos;
	}

	public void addOperandos(Operando operando) {
		this.operandos.add(operando);
	}

	public IndicadorAplicado getIndicadorAplicado() {
		return indicadorAplicado;
	}

	public void setIndicadorAplicado(IndicadorAplicado indicadorAplicado) {
		this.indicadorAplicado = indicadorAplicado;
	}

	// Se fija si el indicador tiene las cuentas necesarias
	// para poder calcularlas, si es asì crea un nuevo objeto
	// que voy a utilizar para poder mostrar los indicadores
	// que se pueden aplicar
	public boolean existeEnPeriodo(List<Empresa> repoEmpresa) {
		listaIndicadores = new ArrayList<IndicadorAplicado>();

		repoEmpresa.forEach(itemEmpresa -> {

			itemEmpresa.getPeriodos().forEach(itemPeriodo -> {
				if (itemPeriodo.existenCuentas(primerOperando, segundoOperando)) {
					
//					BigDecimal valorOperando1 = primerOperando.valor(itemPeriodo);
//					BigDecimal valorOperando2 = segundoOperando.valor(itemPeriodo);
					indicadorAplicado.setAnioPeriodo(itemPeriodo.getPeriodo());
					indicadorAplicado.setNombreEmpresa(itemEmpresa.getNombre());
					indicadorAplicado.setNombreIndicador(nombre);
					indicadorAplicado.setValor( primerOperando.valor(itemPeriodo));
					System.out.println("Nombre de empresa a agregar en lista "+indicadorAplicado.getNombreEmpresa());
					System.out.println("Periodo agregar en lista "+indicadorAplicado.getAnioPeriodo());
					System.out.println("Indicador  a agregar en lista "+indicadorAplicado.getNombreIndicador());
					agregarIndicadorAplicado(indicadorAplicado);
					estado = true;
				} else
					estado = false;
			});
		});

		return estado;
	}

	@Override
	public boolean existe(List<Cuenta> cuentas) {
		// TODO Auto-generated method stub
		return false;
	}
}
