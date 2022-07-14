package com.rgama.pokedex;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="especie")
public class Especie implements Serializable {

	private static final long serialVersionUID = 7583907356380345346L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="especie")
	private String especie;
	
	@OneToMany(mappedBy="especie")
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "id")
	private List<Pokemon> pokemons;
	
	@ManyToMany
	@JoinTable(name="tipos_de_especies",
				joinColumns= @JoinColumn(name="id_especie"),
				inverseJoinColumns=@JoinColumn(name="id_tipo"))
	@JsonManagedReference
	private List<TipoDePokemon> tipos;

	public Especie() {
	}

	public Especie(String especie, List<TipoDePokemon> tipos) {
		this.especie = especie;
		this.tipos = tipos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public List<TipoDePokemon> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoDePokemon> tipos) {
		this.tipos = tipos;
	}
}
