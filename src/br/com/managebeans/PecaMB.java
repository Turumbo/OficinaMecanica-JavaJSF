package br.com.managebeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAO;
import br.com.modelo.Peca;

@ManagedBean
@ViewScoped
public class PecaMB{

	private Peca peca = new Peca();
	private List<Peca> pecas;
	
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public void grava(){
		DAO<Peca> dao = new DAO<Peca>(Peca.class);
		
		if(this.peca.getIdPeca() == null){
			dao.adiciona(peca);
		}else{
			dao.altera(peca);
		}
		
		this.peca = new Peca();
		this.pecas = dao.listaTodos();
	}
	
	public void cancela(){
		this.peca = new Peca();
	}
	
	public void remove(Peca p){
		DAO<Peca> dao = new DAO<Peca>(Peca.class);
		dao.remove(p);
		this.peca = new Peca();
		this.pecas = dao.listaTodos();
	}

	public List<Peca> getPecas() {
		if (pecas==null){
			DAO<Peca> dao = new DAO<Peca>(Peca.class);
			pecas = dao.listaTodos();
		}
		return pecas;		
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
}
