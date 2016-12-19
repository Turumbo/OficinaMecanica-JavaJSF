package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {
	/*Usuario (idusuario, usuario, senha, papel)*/
	
	@Id
	@SequenceGenerator(name="usuario_id", sequenceName="usuario_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id")
	private Long idUsuario;
	private String usuario;
	private String senha;
	private String papel;
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long id) {
		this.idUsuario = id;
	}

	public String getNomeUsuario() {
		return usuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.usuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}
