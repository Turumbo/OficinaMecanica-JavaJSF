package br.com.managebeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dao.UsuarioDAO;
import br.com.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginMB {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			return "gerencia-orcamento?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			return "login?faces-redirect=true";
		}
	}
	
	public boolean isUsuarioLogado() {
		return usuario.getUsuario() != null;
	}
}
