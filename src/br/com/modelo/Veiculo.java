package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Veiculo {
	/*Veiculo (idveiculo, marca, modelo, placa, ano_fabricacao, ano_modelo, #cliente) */
	
	@Id
	@SequenceGenerator(name="veiculo_id", sequenceName="veiculo_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo_id")
	private Long idVeiculo;
	
	@NotEmpty(message="A marca deve ser fornecida")
	private String marca;
	
	@NotEmpty(message="O modelo deve ser fornecido")
	private String modelo;
	
	@NotEmpty(message="A placa deve ser fornecida")
	private String placa;
	
	@NotNull(message="O ano de fabricação deve ser fornecido")
	@Range(min=1950, message="O valor mínimo é 1950")
	private Integer anoFabricacao;
	
	@NotNull(message="O ano do modelo deve ser fornecido")
	@Range(min=1950, message="O valor mínimo é 1950")
	private Integer anoModelo;
	
	/*@OneToOne(mappedBy="veiculo")
	private OrdemServico ordemServico;*/
	
	@OneToOne/*(cascade = CascadeType.ALL)*/
	private Cliente cliente = new Cliente();
	
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
