package br.com.modelo;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrdemServico {
	/*OrdemServico (idos, #veiculo, data_orcamento, data_servico, serviço, valor, status, itens) */
	
	@Id
	@SequenceGenerator(name="os_id", sequenceName="os_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="os_id")
	private Long idOs;
	private Long idVeiculo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataOrcamento = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar dataServico;
	
	private String servico;
	private Float valor;
	private String status = "Criada";
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="ordemServico")
	private Collection<Item> itens;
	
	public Long getIdOs() {
		return idOs;
	}
	public void setIdOs(Long idOs) {
		this.idOs = idOs;
	}
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Calendar getDataOrcamento() {
		return dataOrcamento;
	}
	public void setDataOrcamento(Calendar dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}
	public Calendar getDataServico() {
		return dataServico;
	}
	public void setDataServico(Calendar dataServico) {
		this.dataServico = dataServico;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Collection<Item> getItens() {
		return itens;
	}
	public void setItens(Collection<Item> itens) {
		this.itens = itens;
	}
}
