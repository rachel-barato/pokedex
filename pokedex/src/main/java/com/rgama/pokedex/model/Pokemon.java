package com.rgama.pokedex.model;

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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable {

	private static final long serialVersionUID = -3533836507741093209L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_species", referencedColumnName="id" , nullable=false)
	private Species species;
	
	@Column(name="name")
	private String name;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="attack")
	private Double attack;
	
	@Column(name="defense")
	private Double defense;
	
	@Column(name="gender")
	private String gender;
	
	@ManyToMany(mappedBy="pokemons")
	@JsonManagedReference(value="pokemon-skills")
	private List<Skill> skills;

	@JsonCreator
	public Pokemon() {
	}

	public Pokemon(Pokemon newPokemon) {
		new Pokemon(
				newPokemon.getSpecies(),
				newPokemon.getName(),
				newPokemon.getWeight(),
				newPokemon.getAge(),
				newPokemon.getAttack(),
				newPokemon.getDefense(),
				newPokemon.getGender(),
				newPokemon.getSkills()
				);
	}
	
	public Pokemon(
			@JsonProperty("species") Species species, 
			@JsonProperty("name") String name, 
			@JsonProperty("weight") Double weight, 
			@JsonProperty("age") Integer age, 
			@JsonProperty("attack") Double attack, 
			@JsonProperty("defense") Double defense,
			@JsonProperty("gender") String gender, 
			@JsonProperty("skills") List<Skill> skills) {
		this.species = species;
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.attack = attack;
		this.defense = defense;
		this.gender = gender;
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getAttack() {
		return attack;
	}

	public void setAttack(Double attack) {
		this.attack = attack;
	}

	public Double getDefense() {
		return defense;
	}

	public void setDefense(Double defense) {
		this.defense = defense;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
}
