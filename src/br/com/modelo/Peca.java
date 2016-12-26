package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@OnDelete(action=OnDeleteAction.CASCADE)
public class Peca {
	/*Peca (idpeca, nome, fornecedor, tipo, marca, quantidade) */
	
	@Id
	@SequenceGenerator(name="peca_id", sequenceName="peca_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="peca_id")
	private Long idPeca;
	
	@NotEmpty(message = "O nome deve ser especificado")
	private String nome;
	
	@NotEmpty(message = "O fornecedor deve ser especificado")
	private String fornecedor;
	
	@NotEmpty(message = "O tipo deve ser especificado")
	private String tipo;
	
	@NotEmpty(message = "A marca deve ser especificada")
	private String marca;
	
	@NotNull(message = "A quantidade deve ser especificada")
	private Integer quantidade;
	
	public Long getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Long idPeca) {
		this.idPeca = idPeca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
