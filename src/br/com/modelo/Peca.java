package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Peca {
	/*Peca (idpeca, nome, fornecedor, tipo, marca, quantidade) */
	
	@Id
	@SequenceGenerator(name="peca_id", sequenceName="peca_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="peca_id")
	private Long idPeca;
	private String nome;
	private String fornecedor;
	private String tipo;
	private int marca;
	private int quantidade;
	
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
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
