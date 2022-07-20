package com.rgama.pokedex;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable {

	private static final long serialVersionUID = -3533836507741093209L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@ManyToOne
	@JoinColumn(name="ID_species", nullable=false)
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "id")
	private Species species;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="peso")
	private Double peso;
	
	@Column(name="idade")
	private Integer idade;
	
	@Column(name="ataque")
	private Double ataque;
	
	@Column(name="defesa")
	private Double defesa;
	
	@Column(name="genero")
	private String genero;
	
	@ManyToMany(mappedBy="pokemons")
	private List<Skill> skills;

	public Pokemon() {
	}

	public Pokemon(Species species) {
		this.species = species;
	}

	public Pokemon(
			Integer iD, Species species, 
			String nome, Double peso, 
			Integer idade, Double ataque,
			Double defesa, String genero
	) {
		ID = iD;
		this.species = species;
		this.nome = nome;
		this.peso = peso;
		this.idade = idade;
		this.ataque = ataque;
		this.defesa = defesa;
		this.genero = genero;
	}

	public Integer getID() {
		return ID; 
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getAtaque() {
		return ataque;
	}

	public void setAtaque(Double ataque) {
		this.ataque = ataque;
	}

	public Double getDefesa() {
		return defesa;
	}

	public void setDefesa(Double defesa) {
		this.defesa = defesa;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
