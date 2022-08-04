package com.rgama.pokedex.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="species")
public class Species implements Serializable {

	private static final long serialVersionUID = 7583907356380345346L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="species")
	@JsonBackReference(value="species-pokemons")
	private List<Pokemon> pokemons;
	
	@ManyToMany
	@JoinTable(name="types_species",
				joinColumns= @JoinColumn(name="id_species"),
				inverseJoinColumns=@JoinColumn(name="id_type"))
	private List<PokemonType> pokemonTypes;

	@ManyToMany
	@JoinTable(name="species_skills",
				joinColumns= @JoinColumn(name="id_specie"),
				inverseJoinColumns=@JoinColumn(name="id_skill"))
	private List<Skill> specieSkills;

	public Species() {
	}

	public Species(Species newSpecies) {
		this.name = newSpecies.getName();
		this.pokemonTypes = newSpecies.getPokemonTypes();
	}

	public Species(String name, List<PokemonType> pokemonTypes) {
		this.name = name;
		this.pokemonTypes = pokemonTypes;
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

	public List<PokemonType> getPokemonTypes() {
		return pokemonTypes;
	}

	public void setPokemonTypes(List<PokemonType> pokemonTypes) {
		this.pokemonTypes = pokemonTypes;
	}
	
	public List<Skill> getSpecieSkills() {
		return specieSkills;
	}

	public void setSpecieSkills(List<Skill> specieSkills) {
		this.specieSkills = specieSkills;
	}
}
