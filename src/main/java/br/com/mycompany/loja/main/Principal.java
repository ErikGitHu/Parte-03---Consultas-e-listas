package br.com.mycompany.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.dao.CategoriaDao;
import br.com.mycompany.loja.dao.ProdutoDao;
import br.com.mycompany.loja.modelo.Categoria;
import br.com.mycompany.loja.modelo.Produto;
import br.com.mycompany.loja.util.JPAUtil;

public class Principal {
	
	public static void main(String[] args) {
		Categoria categoria = new Categoria("Tamanho");
		Produto produto = new Produto("Computador", "Sistema operacional Windows64, com 8gb de ram e 1 terabyte de armazenamento", new BigDecimal(4000), categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		categoria.setNome("Tamanho");
		em.flush();
		em.clear();
		
		categoria = em.merge(categoria);
		categoria.setNome("Desempenho");
		em.flush();
		
		em.remove(categoria);
		em.clear();
	}
	
}
