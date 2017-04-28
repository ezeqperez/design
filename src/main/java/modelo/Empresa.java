package modelo;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Ezequiel on 24/4/2017.
 */
public class Empresa {
	

    private String nombreEmpresa;
    private List<Cuenta> cuentas;
	private boolean estado = false;


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
	public boolean existeEmpresa(List<Empresa> listaEmpresa)
	{

		listaEmpresa.forEach(item->{
			if(item.getNombreEmpresa() == item.getNombreEmpresa())
			{
			this.estado =  true;
			}
		});
		return estado;
	}
}
