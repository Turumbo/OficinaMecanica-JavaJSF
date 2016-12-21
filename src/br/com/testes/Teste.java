package br.com.testes;

import br.com.managebeans.ClienteMB;

public class Teste {
	public static void main(String[] args) {
		/*Cliente c = new Cliente();
		c.setCpf("1029380912");
		c.setEmail("wet");
		c.setEndereco("fefqwe");
		c.setNome("Luan");
		c.setPlacaVeiculo("24");
		c.setTelefone("1");
	
		
		new DAO<Cliente>(Cliente.class).adiciona(c);		*/
		ClienteMB a = new ClienteMB();
		System.out.println(a.getNomePorId(14L));
		
	}
}
