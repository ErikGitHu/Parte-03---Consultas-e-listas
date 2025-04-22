package br.com.mycompany.loja.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.dao.CategoriaDao;
import br.com.mycompany.loja.dao.ClienteDao;
import br.com.mycompany.loja.dao.PedidoDao;
import br.com.mycompany.loja.dao.ProdutoDao;
import br.com.mycompany.loja.modelo.Categoria;
import br.com.mycompany.loja.modelo.Cliente;
import br.com.mycompany.loja.modelo.ItemPedido;
import br.com.mycompany.loja.modelo.Pedido;
import br.com.mycompany.loja.modelo.Produto;
import br.com.mycompany.loja.util.JPAUtil;

public class Principal {
	public static void main(String[] args) {
		Lição_prática_I_e_II();
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		Categoria p = categoriaDao.consultar(1l);
		Produto produto = produtoDao.consultar(1l);
		Cliente cliente = clienteDao.consultar(1l);
		
		System.out.println(p.getNome());
		
		List<Categoria> categoria = categoriaDao.consultarLista();
		categoria.forEach(c -> System.out.println(c.getNumero()));
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
	}

	private static void Lição_prática_I_e_II() {
		Categoria c1 = new Categoria("Tamanho", "10");
		Categoria c2 = new Categoria("Desempenho", "11");
		Categoria c3 = new Categoria("Tipo de processamento", "12");
		
		Produto produto = new Produto("Computador", "Sistema operacional Windows64, com 8gb de ram e 1 terabyte de armazenamento", new BigDecimal(4000), c1, c2, c3);
		
		Cliente cliente = new Cliente("Renato", "12345678900");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		em.persist(c1);
		c1.setNome("Tamano");/*Em vista de um erro por negligência no código fonte, é necessário atualizar o sistema*/
		em.flush();
		em.clear();
		
		c1 = em.merge(c1);
		c1.setNome("Tamanho");
		em.flush();
		
		em.remove(c1);
		em.clear();
	}
	
}
