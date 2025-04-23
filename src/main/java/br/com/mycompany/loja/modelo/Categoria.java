package br.com.mycompany.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {
	}

	public Categoria(String nome, String numero) {
		this.id = new CategoriaId(nome, numero);
	}

	public String getNome() {
		return this.id.getNome();
	}
	
}
