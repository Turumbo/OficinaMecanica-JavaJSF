package br.com.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.tabview.TabView;

import br.com.dao.DAO;
import br.com.modelo.Item;
import br.com.modelo.OrdemServico;
import br.com.modelo.Peca;

@ManagedBean
@ViewScoped
public class OrdemServicoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private Item item = new Item();
	private OrdemServico ordemServico = new OrdemServico();
	private List<OrdemServico> ordensServico;
	private TabView tabView;
	
	private Long idPeca = new Long(0);
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}	
	public Long getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Long idPeca) {
		this.idPeca = idPeca;
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public TabView getTabView() {
		return tabView;
	}
	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	public void cancela(){
		this.ordemServico = new OrdemServico();
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
		tabView.setActiveIndex(1);
	}
	
	public void aprova(OrdemServico os){
		DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
		os.setStatus("Aprovada");
		dao.altera(os);
		this.ordemServico = new OrdemServico();
		this.ordensServico = dao.listaTodos();
	}
	
	public void remove(OrdemServico p){
		DAO<OrdemServico> dao = new DAO<OrdemServico>(OrdemServico.class);
		dao.remove(p);
		this.ordemServico = new OrdemServico();
		this.ordensServico = dao.listaTodos();
	}
	
	public void removeItem(Item item){
		this.ordemServico.getItens().remove(item);
	}
	
	public void guardaPeca(){
		DAO<Peca> dao = new DAO<>(Peca.class);
		Peca peca = dao.buscaPorld(idPeca);		
		item.setPeca(peca);
		item.setOrdemServico(ordemServico);
		this.ordemServico.getItens().add(item);
		item = new Item();
	}
}
