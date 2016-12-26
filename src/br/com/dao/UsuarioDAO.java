package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelo.Usuario;

public class UsuarioDAO {
	public Usuario existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Usuario u where u.usuario = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getUsuario());
		query.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		Usuario u = null;
		
		if(encontrado){
			u = (Usuario)query.getSingleResult();
		}
		
		em.getTransaction().commit();
		em.close();
		return u;
	}
}
