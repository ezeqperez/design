package vista.MetodologiasMock;

import modelo.dominio.Empresa;
import modelo.dominio.Indicador;
import modelo.dominio.Metodologia;

import java.util.ArrayList;
import java.util.List;

public class MetodologiasMock {

    public static List<Empresa> getEmpresas(){

        final List<Empresa> empresas = new ArrayList<>();
        final Empresa facebook = new Empresa();
        facebook.setNombre("Facebook");
        empresas.add(facebook);

        final Empresa gitHub = new Empresa();
        gitHub.setNombre("GitHub");
        empresas.add(gitHub);

        final Empresa utn = new Empresa();
        gitHub.setNombre("Utn");
        empresas.add(utn);

        return empresas;
    }

    public static List<Metodologia> getMetodologias(){

        final List<Metodologia> metodologias = new ArrayList<>();
        final Metodologia metodologiaUno = new Metodologia();
        metodologiaUno.setNombre("Meto Uno");
        metodologias.add(metodologiaUno);

        final Metodologia metodologiaDos = new Metodologia();
        metodologiaDos.setNombre("Meto Dos");
        metodologias.add(metodologiaDos);

        final Metodologia metodologiaTres = new Metodologia();
        metodologiaTres.setNombre("Meto Tres");
        metodologias.add(metodologiaTres);

        return metodologias;
    }

    public static List<Empresa> getEmpresasFiltradas(){

        final List<Empresa> empresas = new ArrayList<>();
        final Empresa facebook = new Empresa();
        facebook.setNombre("Facebook");
        empresas.add(facebook);

        final Empresa gitHub = new Empresa();
        gitHub.setNombre("GitHub");
        empresas.add(gitHub);

        return empresas;
    }

    public static List<Indicador> getIndicadores(){

        final List<Indicador> indicadores = new ArrayList<>();
        final Indicador roe = new Indicador();
        roe.setNombre("ROE");
        indicadores.add(roe);

        final Indicador proporcionDeuda = new Indicador();
        roe.setNombre("Proporcion de deuda");
        indicadores.add(proporcionDeuda);

        return indicadores;
    }

}
