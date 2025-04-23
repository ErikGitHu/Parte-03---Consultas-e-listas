package br.com.mycompany.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.mycompany.loja.modelo.Categoria;
import br.com.mycompany.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto consultar(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> consultarPorParametros(String nome, String descricao, BigDecimal preco, LocalDate data){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		if(nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if(descricao != null && !descricao.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("descricao"), descricao));
		}
		if(preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if(data != null) {
			filtros = builder.and(filtros, builder.equal(from.get("data"), data));
		}
		query.where(filtros);
		return em.createQuery(query).getResultList();
	}
}
