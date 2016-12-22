package br.com.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Veiculo {
	/*Veiculo (idveiculo, marca, modelo, placa, ano_fabricacao, ano_modelo, #cliente) */
	
	@Id
	@SequenceGenerator(name="veiculo_id", sequenceName="veiculo_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo_id")
	private Long idVeiculo;
	private String marca;
	private String modelo;
	private String placa;
	private Integer anoFabricacao;
	private Integer anoModelo;
	
	/*@OneToOne(mappedBy="veiculo")
	private OrdemServico ordemServico;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
