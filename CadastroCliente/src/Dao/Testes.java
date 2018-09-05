package Dao;

import Entidades.Cliente;
import Dao.ClienteDao;

public class Testes {
	public static void main(String[] args) {

		Testes teste = new Testes();
		teste.cadastrar();
		teste.remover();
		teste.atualizar();
	    

	}

	public void cadastrar() {

		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();

		cliente.setNome("Thiago");

		dao.salvar(cliente);

		System.out.println("\nClientes cadastrado: ");
		System.out.println("Código: " + cliente.getId() + "\nNome: " + cliente.getNome());

	}

	public void remover() {

		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();

		cliente = dao.remover((long) 1);

		System.out.println("Cliente Removido com Sucesso: " + cliente.getNome());

	}
	public void atualizar() {
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		dao.atualizarCliente(cliente);
		cliente.setNome("Rafael");
		System.out.println("Cliente Atualizado com Sucesso");
		
		
	}



}
