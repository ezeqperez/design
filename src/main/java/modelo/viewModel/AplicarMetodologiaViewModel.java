package modelo.viewModel;

import modelo.dominio.Empresa;
import modelo.repositorios.EmpresasRepository;

import java.util.List;

public class AplicarMetodologiaViewModel {

    public void aplicarMetodologia(){
        final List<Empresa> empresas = EmpresasRepository.getInstance().getEmpresas();

        //le pasa la lista de empresas a la meodologia seleccionada
        //List<Empresa> empresasFiltradas = metodologiaSeleccionada.aplicar(empresas);

        //setear la lista de empresas que devuelve, a lo bindeado

    }
}
