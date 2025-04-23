package br.com.mycompany.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{

	private String nome;
	private String numero;
	
	public CategoriaId() {
	}

	public CategoriaId(String nome, String numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public CategoriaId(String nome2) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
