package br.com.mycompany.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.dao.ProdutoDao;
import br.com.mycompany.loja.model.Categoria;
import br.com.mycompany.loja.model.Produto;
import br.com.mycompany.loja.util.JPAUtil;

public class Usuario {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("Básico");
		Produto produto = new Produto("Notebook", "Design leve e compacto", new BigDecimal(3449.90), categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		em.persist(produto);
		produto.setNome("PC");
		em.flush();
		
		em.clear();
		
		produto = em.merge(produto);
		produto.setNome("Notebook");
		em.flush();
		
		em.remove(produto);
		em.clear();
		
	}
	
}
