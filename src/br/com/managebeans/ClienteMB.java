package br.com.managebeans;

import java.util.InputMismatchException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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

	public String getNomePorId(Long idCliente){
		if (clientes==null){
			DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
			clientes = dao.listaTodos();
		}
		for(Cliente c : clientes){
			if(c.getIdCliente() == idCliente){
				return c.getNome();
			}
		}
		return "";
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

	/**
	 * Verifica se uma string recebida por parâmetro está no formato correto para ser um CPF e se seus dígitos correspondem
	 * a um CPF válido. Caso positivo, retorna true, senão, retorna false.
	 * */
	public void validarCpf(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		String cpf = value.toString();
		if(validarFormatoCpf(cpf) && isCPF(cpf.replace(".", "").replace("-", "")) == false){
			throw new ValidatorException(new FacesMessage("Um CPF válido deve ser inserido"));
		}
	}

	/**
	 * Valida se uma string recebida por parâmetro está no formato correto para CPF, ou seja, segue a 
	 * máscara DDD.DDD.DDD-DD. Caso positivo, retorna true, senão, retorna false.
	 * */
	private boolean validarFormatoCpf(String cpf){
		return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
	}

	/**
	 * Valida se uma string recebida por parâmetro corresponde a um CPF válido, seguindo às regras estabelecidas para
	 * cálculo de CPF. Caso positivo, retorna true, senão, retorna false.
	 * */
	private boolean isCPF(String cpf) {
		// Considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999") ||
				(cpf.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o cada caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0         
				// (48 corresponde à posicao de '0' na tabela ASCII)         
				num = (int)(cpf.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // Converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
	}

}
