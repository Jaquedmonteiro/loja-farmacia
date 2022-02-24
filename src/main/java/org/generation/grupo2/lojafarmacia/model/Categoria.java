package org.generation.grupo2.lojafarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Atributo 1
	@NotNull
	@Size(min = 3, max = 20)
	private String nomeCat;

	// Atributo 2
	@NotNull
	@Size(min = 3, max = 20)
	private String nomeAtendente;


	public long getId() {
		return id;

	}

	public void setId(long id) {
		this.id = id;

	}

	public String getNomeCat() {
		return nomeCat;
	}

	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

}

