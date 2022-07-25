package com.rgama.pokedex.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pokemon_type")
public class PokemonType implements Serializable {

	private static final long serialVersionUID = -4280761226411858773L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy="pokemonTypes")
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "id")
	@JsonBackReference
	private List<Species> species;

	public PokemonType() {
	}

	public PokemonType(PokemonType newPokemonType) {
		this.name = newPokemonType.getName();
		this.species = newPokemonType.getSpecies();
	}

	public PokemonType(String name, List<Species> species) {
		this.name = name;
		this.species = species;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}
}
