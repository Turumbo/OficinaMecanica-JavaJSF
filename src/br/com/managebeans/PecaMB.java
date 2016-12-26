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
	private Integer quantidade = new Integer(0);
	
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
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void retirar(Peca p){
		DAO<Peca> dao = new DAO<>(Peca.class);
		int diferenca = p.getQuantidade() - quantidade;
		
		/* 
		 * Verifica se a quantidade armazenada de pe�as � menor ou igual � quantidade solicitada.
		 * Caso o usu�rio tenha solicitado mais pe�as que o dispon�vel ou mesmo tenha solicitado todas as dispon�veis,
		 * todas as pe�as dispon�veis s�o retiradas do estoque.
		 */
		if(diferenca < 0 || diferenca == 0){
			dao.remove(p);
		}else{ 
			/*
			 * Caso contr�rio, retira apenas a quantidade desejada e mant�m o cadastro daquela pe�a, pois ainda
			 * existem unidades no estoque daquele modelo.
			 */
			p.setQuantidade(diferenca);
			dao.altera(p);
		}
		
		this.quantidade = 0;
	}
}
