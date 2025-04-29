package br.com.mycompany.loja.dao;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.model.Produto;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
}
