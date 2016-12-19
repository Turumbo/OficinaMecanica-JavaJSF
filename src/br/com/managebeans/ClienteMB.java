package br.com.managebeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAO;
import br.com.modelo.Cliente;

@ManagedBean
@ViewScoped
public class ClienteMB{

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void grava(){
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		
		if(this.cliente.getIdCliente() == null){
			dao.adiciona(cliente);
		}else{
			dao.altera(cliente);
		}
		
		this.cliente = new Cliente();
		this.clientes = dao.listaTodos();
	}
	
	public void cancela(){
		this.cliente = new Cliente();
	}
	
	public void remove(Cliente p){
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		dao.remove(p);
		this.cliente = new Cliente();
		this.clientes = dao.listaTodos();
	}

	public List<Cliente> getClientes() {
		if (clientes==null){
			DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
			clientes = dao.listaTodos();
		}
		return clientes;		
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
