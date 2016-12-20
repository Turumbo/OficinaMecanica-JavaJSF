package br.com.managebeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAO;
import br.com.modelo.OrdemServico;

@ManagedBean
@ViewScoped
public class OrdemServicoMB{

	private OrdemServico ordemServico = new OrdemServico();
	private List<OrdemServico> ordensServico;
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	
	public void grava(){
		DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
		
		if(this.ordemServico.getIdOs() == null){
			dao.adiciona(ordemServico);
		}else{
			dao.altera(ordemServico);
		}
		
		this.ordemServico = new OrdemServico();
		this.ordensServico = dao.listaTodos();
	}
	
	public void aprova(OrdemServico os){
		DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
		os.setStatus("Aprovada");
		dao.altera(os);
		this.ordemServico = new OrdemServico();
		this.ordensServico = dao.listaTodos();
	}
	
	public void cancela(){
		this.ordemServico = new OrdemServico();
	}
	
	public void remove(OrdemServico p){
		DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
		dao.remove(p);
		this.ordemServico = new OrdemServico();
		this.ordensServico = dao.listaTodos();
	}

	public List<OrdemServico> getOrdensServico() {
		if (ordensServico==null){
			DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
			ordensServico = dao.listaTodos();
		}
		return ordensServico;		
	}

	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}
	
}
