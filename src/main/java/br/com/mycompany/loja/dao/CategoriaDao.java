package br.com.mycompany.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.mycompany.loja.modelo.Categoria;
import br.com.mycompany.loja.modelo.Produto;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public Categoria consultar(Long id) {
		return em.find(Categoria.class, id);
	}
	
	public List<Categoria> consultarLista(){
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class)
				.getResultList();
	}

}
