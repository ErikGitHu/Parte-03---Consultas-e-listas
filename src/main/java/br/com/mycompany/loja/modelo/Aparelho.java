package br.com.mycompany.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Aparelho extends Produto {
	
	private String marca;
	private String modelo;
	
	public Aparelho(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public Aparelho() {
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
