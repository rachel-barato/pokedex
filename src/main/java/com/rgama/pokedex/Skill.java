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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = -801090549379541646L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="effect")
	private String effect;
	
	@ManyToMany
	@JoinTable(name="skills_de_pokemon",
				joinColumns= @JoinColumn(name="id_skill"),
				inverseJoinColumns=@JoinColumn(name="id_pokemon"))
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "id")
	private List<Pokemon> pokemons;

	public Skill() {
	}

	public Skill(String name, String effect, List<Pokemon> pokemons) {
		this.nome = name;
		this.effect = effect;
		this.pokemons = pokemons;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
}
