package modelo;

import java.util.List;
import java.lang.*;

public class RepoEmpresa {
	
	List<Empresa> repos;
	
	public List<Empresa> getRepos() {
		return repos;
	}
	
	
	
	public void setRepos(List<Empresa> repos) {
		this.repos = repos;
	}
	
	public void findOrCreate(List<Empresa> lista)
	{
		lista.forEach(item->{
			if(item.existeEmpresa(repos)){
				System.out.println("Se debe actualizar la cuenta de la empresa: " +item.getNombreEmpresa());

			}
			else{
				this.repos.add(item);
			}
		}
		);
	}



}
