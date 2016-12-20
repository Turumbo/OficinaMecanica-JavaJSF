package br.com.managebeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAO;
import br.com.modelo.Veiculo;

@ManagedBean
@ViewScoped
public class VeiculoMB{

	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> veiculos;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public String getNomePorId(Long idVeiculo){
		if (veiculos==null){
			DAO<Veiculo> dao = new DAO<Veiculo>(Veiculo.class);
			veiculos = dao.listaTodos();
		}
		for(Veiculo v : veiculos){
			if(v.getIdVeiculo() == idVeiculo){
				return v.getModelo();
			}
		}
		
		return "";
	}
	
	public void grava(){
		DAO<Veiculo> dao = new DAO<Veiculo>(Veiculo.class);
		
		if(this.veiculo.getIdVeiculo() == null){
			dao.adiciona(veiculo);
		}else{
			dao.altera(veiculo);
		}
		
		this.veiculo = new Veiculo();
		this.veiculos = dao.listaTodos();
	}
	
	public void cancela(){
		this.veiculo = new Veiculo();
	}
	
	public void remove(Veiculo p){
		DAO<Veiculo> dao = new DAO<Veiculo>(Veiculo.class);
		dao.remove(p);
		this.veiculo = new Veiculo();
		this.veiculos = dao.listaTodos();
	}

	public List<Veiculo> getVeiculos() {
		if (veiculos==null){
			DAO<Veiculo> dao = new DAO<Veiculo>(Veiculo.class);
			veiculos = dao.listaTodos();
		}
		return veiculos;		
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
