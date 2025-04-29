package br.com.mycompany.loja.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.dao.ProdutoDao;
import br.com.mycompany.loja.model.Categoria;
import br.com.mycompany.loja.model.Produto;
import br.com.mycompany.loja.util.JPAUtil;

public class Usuario {

	public static void main(String[] args) {
		licao_pratica_1_e_2();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.consultarPorId(1l);
		System.out.println(p.getNome());
		
		BigDecimal listarPorPreco = produtoDao.consultarPorPreco("Notebook");
		System.out.println(listarPorPreco);
		
		List<Produto> listarTudo = produtoDao.consultarTudo();
		listarTudo.forEach(t -> System.out.println(t));
		
	}

	private static void licao_pratica_1_e_2() {
		Categoria categoria = new Categoria("Básico");
		Produto produto = new Produto("Notebook", "Design leve e compacto", new BigDecimal(3449.90), categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		em.persist(produto);
		produto.setNome("Notebook");
		em.flush();
		
		em.clear();
		
		produto = em.merge(produto);
		produto.setNome("Notebook");
		em.flush();
		
		em.remove(produto);
		em.clear();
	}
	
}
