package Dao;

import java.awt.List;

import javax.persistence.EntityManager;
import Conexao.Conexao;
import Entidades.Cliente;

public class ClienteDao {

	EntityManager manager = new Conexao().getEntityManager();

	// Adicionar Cliente
	public void salvar(Cliente c) {

		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Cliente salvo com Sucesso!");

	}

	// Remover Cliente
	public Cliente remover(Long id) {

		Cliente c = null;
		c = manager.find(Cliente.class, id);
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
		System.out.println("Cliente Removido com Sucesso.");

		return c;

	}

	// Listar Clientes
	public List listar() {

		List clientes = null;

		clientes = (List) manager.createQuery("from Cliente c").getResultList();
		System.out.println(clientes);

		return clientes;

	}

	// Busca por Eager
	public Cliente consultarPorIdporEager(Long id) {
		Cliente cliente = null;
		try {
			cliente = manager.find(Cliente.class, id);
		} finally {
			manager.close();
		}
		return cliente;
	}

	// Busca por Lazy
	public Cliente consultarPorIdporLazy(Long id) {
		Cliente cliente = null;
		try {
			cliente = manager.getReference(Cliente.class, id);
		} finally {
			manager.close();
		}
		return cliente;
	}

	// Atualiza Cliente
	public Cliente atualizarCliente(Cliente cliente) {

		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();
		manager.close();
		return cliente;
	}

	// Desvincular Cliente
	public Cliente desvincularCliente(Cliente cliente) {

		manager.detach(cliente);

		return cliente;
	}

}