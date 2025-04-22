package br.com.mycompany.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mycompany.loja.modelo.Pedido;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal consultarPorAgregacao(){
		String jpql = "consultaPorAgregacao";
		return em.createNamedQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<Pedido> relatorioDeVendas(){
		String jpql = "SELECT new br.com.mycompany.loja.vo.RelatorioDeVendasVO("
				     +"produto.nome,"
				     +"SUM(item.quantidade) as quantidadeTotal,"
				     +"MAX(pedido.data))"
				     +"FROM Pedido pedido"
				     +"JOIN pedido.itens item"
				     +"JOIN item.produto produto"
				     +"GROUP BY produto.nome,"
				     +"ORDER BY quantidadeTotal DESC";
		
		return em.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public Pedido consultarPorIdComCliente(Long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id =: id";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
