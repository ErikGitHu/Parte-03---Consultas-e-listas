package br.com.mycompany.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVO {
	
	private Long id;
	private String nomeDoProduto;
	private String quantidadeDeVendas;
	private LocalDate dataUltimaVenda = LocalDate.now();
	
	@Override
	public String toString() {
		return "RelatorioDeVendasVO [id=" + id + ", nomeDoProduto=" + nomeDoProduto + ", quantidadeDeVendas="
				+ quantidadeDeVendas + ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}

	public RelatorioDeVendasVO(String nomeDoProduto, String quantidadeDeVendas, LocalDate dataUltimaVenda) {
		this.nomeDoProduto = nomeDoProduto;
		this.quantidadeDeVendas = quantidadeDeVendas;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public Long getId() {
		return id;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public String getQuantidadeDeVendas() {
		return quantidadeDeVendas;
	}

	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}
	
}
