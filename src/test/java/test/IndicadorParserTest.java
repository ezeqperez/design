package test;

import modelo.dominio.Indicador;
import modelo.repositorios.IndicadoresRepository;
import modelo.viewModel.IndicadorViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IndicadorParserTest {
    private IndicadorViewModel viewModel;
    private Indicador indicador;
    
    @Before
    public void initialize() {
        IndicadorViewModel viewModel = new IndicadorViewModel();
        viewModel.setNombre("Pirulo");
        viewModel.setFormula("2+4");
        viewModel.guardarIndicador();


    }

    @Test
    public void devuelveIndicadorOK() {
    	Assert.assertEquals(IndicadoresRepository.getInstance().search("Pirulo").getNombre(), "Pirulo");
    }

    @Test

    public void cargaDosIndicadores() {
        IndicadorViewModel vm = new IndicadorViewModel();
        vm.setNombre("Cachita");
        vm.setFormula("2+Montaner");
        vm.guardarIndicador();

        Assert.assertEquals(IndicadoresRepository.getInstance().getIndicadores().size(), 2);
    }

}
