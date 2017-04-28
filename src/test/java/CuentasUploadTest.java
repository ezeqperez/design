import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import utils.CuentasUpload;
import modelo.Empresa;
import utils.JsonParser;
import modelo.RepoEmpresa;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class CuentasUploadTest {
	

		String empresa =
					"{\"nombreEmpresa\":empresa1\","
					+ "\"cuentas\":"
						+ "["
							+ "{\"cuentaNombre\":\"ROE\",\"periodo\":2003},"
							+ "{\"cuentaNombre\":\"ROA\",\"periodo\":2017,\"valor\":11557}"
						+ "]"
					+ "}";
	
		String empresasConCuentas =
			"["
				+ "{"
					+ "\"nombreEmpresa\":empresa1\","
					+ "\"cuentas\":"
						+ "["
							+ "{\"cuentaNombre\":\"ROE\",\"periodo\":2003},"
							+ "{\"cuentaNombre\":\"ROA\",\"periodo\":2017,\"valor\":11557}"
						+ "]"
				+ "},"
				+ "{"
					+ "\"nombreEmpresa\":empresa2\","
					+ "\"cuentas\":"
						+ "["
							+ "{\"cuentaNombre\":\"ROBE\",\"periodo\":2103},"
							+ "{\"cuentaNombre\":\"ROA3\",\"periodo\":201327,\"valor\":111557}"
						+ "]"
				+ "}"
			+ "]";
		
		String empresasConCuentas2 =
				"["
					+ "{"
						+ "\"nombreEmpresa\":empresa1\","
						+ "\"cuentas\":"
							+ "["
								+ "{\"cuentaNombre\":\"ROE\",\"periodo\":2003},"
								+ "{\"cuentaNombre\":\"ROA\",\"periodo\":2017,\"valor\":11557}"
							+ "]"
					+ "},"
					+ "{"
						+ "\"nombreEmpresa\":empresa3\","
						+ "\"cuentas\":"
							+ "["
								+ "{\"cuentaNombre\":\"ROBE\",\"periodo\":2103},"
								+ "{\"cuentaNombre\":\"ROA3\",\"periodo\":201327,\"valor\":111557}"
							+ "]"
					+ "}"
				+ "]";
	
	@Test
	public void testCrearEmpresaSimple(){
		JsonParser jsonParser = new JsonParser();
		String jsonInString = "{\"nombreEmpresa\":\"empresaTest\"}";
		Empresa empresa2 = jsonParser.jsonAEmpresa(jsonInString);
		Assert.assertEquals(empresa2.getNombreEmpresa(), "empresaTest");
	}
	
	@Test
	public void testCrearEmpresas(){
		JsonParser jsonParser = new JsonParser();
		String jsonInString = empresasConCuentas;
		Empresa empresa2 = jsonParser.jsonAEmpresa(jsonInString);
		Assert.assertEquals(empresa2.getNombreEmpresa(), "empresaTest");
	}
				
	@Test
	public void testCargarCuentasAUnaEmpresa(){
		Gson gson = new Gson();
		Empresa empresa2 = gson.fromJson(empresasConCuentas,Empresa.class);
		Assert.assertEquals(empresa2.getCuentas().size(), 2);
	}
	
	@Test
	public void testCargarCuentasAVariasEmpresas(){
		
		//Esto va al parser
		Gson gson = new Gson();
		
		Type listType = new TypeToken<ArrayList<Empresa>>(){}.getType();
		List<Empresa> listaRepoEmpresas = gson.fromJson(empresasConCuentas,listType);
		RepoEmpresa repoEmpresas = new RepoEmpresa();
		repoEmpresas.setRepos(listaRepoEmpresas);
		
		Type listType2 = new TypeToken<ArrayList<Empresa>>(){}.getType();
		List<Empresa> listaEmpresasActualizar = gson.fromJson(empresasConCuentas2,listType2);
		
		repoEmpresas.findOrCreate(listaEmpresasActualizar);
		
		
	Assert.assertEquals(repoEmpresas.getRepos().size(), 321);
	}
	
	
	
	
}
