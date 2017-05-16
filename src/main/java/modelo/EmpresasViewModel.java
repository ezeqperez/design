package modelo;

import modelo.repositorio.EmpresasRepository;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import utils.IJSONUploader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Observable
public class EmpresasViewModel {
    // Esta clase procesa las empresas que se cargan desde el archivo.

    private String ruta;  //Ruta donde se va a buscar el archivo a procesar
    private IJSONUploader jsonUploader; // Dependencia
    private EmpresasRepository repoEmpresas = new EmpresasRepository();
    //private List<Cuenta> cuentasFiltradas; // Cuentas que cumplen el filtro de empresa y de periodo
    private String empresaFilter;
    private int periodoFilter;

    public EmpresasViewModel(IJSONUploader empresasUploader) {
        this.jsonUploader = empresasUploader;
        //this.empresas = new ArrayList<Empresa>();
        //this.cuentasFiltradas = new ArrayList<Cuenta>();
        this.ruta = "C:\\test.json"; //Comienza con una ruta por defecto
    }

    public void cargarEmpresas() throws org.json.simple.parser.ParseException {
        repoEmpresas.agregarEmpresas(jsonUploader.procesarArchivo(ruta));
    }


    public void filtrarEmpresas() {
        repoEmpresas.filtrarEmpresas(empresaFilter);

        /*
        repoEmpresas.filtrarEmpresas

        try {
            Objects.requireNonNull(this.periodoFilter);
            Objects.requireNonNull(this.empresaFilter);
            cuentasFiltradas = empresas.stream()
                    .filter(cuenta -> Objects.equals(cuenta.getPeriodo(), this.periodoFilter)
                            && Objects.equals(cuenta.getEmpresa(), this.empresaFilter))
                    .collect(Collectors.toList());

        } catch (NullPointerException e) {
            throw new UserException("Los valores periodo y empresa no pueden estar vacios");
        }

        */
    }

    // Getters y setters
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public IJSONUploader getJsonUploader() {
        return jsonUploader;
    }

    public void setJsonUploader(IJSONUploader jsonUploader) {
        this.jsonUploader = jsonUploader;
    }

    /*
    public List<Cuenta> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Cuenta> empresas) {
        this.empresas = empresas;
    }

    public void addCuentas(Cuenta cuenta) {
        this.empresas.add(cuenta);
    }

    public String getEmpresaFilter() {
        return empresaFilter;
    }
*/


    public void setEmpresaFilter(String empresaFilter) {
        this.empresaFilter = empresaFilter;
    }

    public int getPeriodoFilter() {
        return periodoFilter;
    }

    public void setPeriodoFilter(int periodoFilter) {
        this.periodoFilter = periodoFilter;
    }

    /*
    public List<Cuenta> getCuentasFiltradas() {
        return cuentasFiltradas;
    }

    public void setCuentasFiltradas(List<Cuenta> cuentasFiltradas) {
        this.cuentasFiltradas = cuentasFiltradas;
    }

}
  */


}