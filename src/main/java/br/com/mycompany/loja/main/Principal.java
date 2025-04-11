package br.com.mycompany.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.dao.ProdutoDao;
import br.com.mycompany.loja.modelo.Produto;
import br.com.mycompany.loja.util.JPAUtil;

public class Principal {
	
	public static void main(String[] args) {
		
		Produto produto = new Produto("Computador", "Sistema operacional Windows64, com 8gb de ram e 1 terabyte de armazenamento", new BigDecimal(4000));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		produtoDao.cadastrar(produto);
		em.getTransaction().commit();
		
	}
	
}
