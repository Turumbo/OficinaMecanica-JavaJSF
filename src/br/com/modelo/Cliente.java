package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cliente {
	/*Cliente (idcliente, nome, telefone, placa do veículo, CPF, endereço, email) */

	@Id
	@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_id")
	private Long idCliente;
	
	@NotEmpty(message = "O nome deve ser especificado")
	private String nome;
	
	@NotEmpty(message = "O telefone deve ser especificado")
	private String telefone;
	
	private String cpf;
	
	@NotEmpty(message = "Um endereço deve ser especificado")
	private String endereco;
	
	private String email;
	
	/*@OneToMany(mappedBy = "cliente")
	private Collection<Veiculo> veiculos;*/
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idcliente) {
		this.idCliente = idcliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
