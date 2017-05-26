package utils.Empresas;

import modelo.dominio.Cuenta;
import modelo.dominio.Empresa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmpresasUploadMock implements EmpresasUploader {
    List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public List<Empresa> procesarArchivo(String ruta) {
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setMonto(new BigDecimal(999));
        List<Empresa> tresCuentas = new ArrayList<>();
        return tresCuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}