package com.rgama.pokedex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.EntityNotFoundException;
import com.rgama.pokedex.pokemon.Pokemon;
import com.rgama.pokedex.pokemon.PokemonRepository;
import com.rgama.pokedex.pokemonType.PokemonType;
import com.rgama.pokedex.pokemonType.PokemonTypeRepository;
import com.rgama.pokedex.skill.Skill;
import com.rgama.pokedex.skill.SkillRepository;
import com.rgama.pokedex.species.Species;
import com.rgama.pokedex.species.SpeciesRepository;

@Service
public class PokedexService {
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private PokemonTypeRepository pokemonTypeRepository;
	
	public Pokemon createNewPokemon(Pokemon newPokemon) {
		return  pokemonRepository.save(newPokemon);
	}
	
	public List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon getPokemonById(Integer id) {
		return pokemonRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("pokemon", id));
	}
	
	public void deletePokemon(Integer id) {
		pokemonRepository.deleteById(id);
	}
	
	public Pokemon replacePokemon(Pokemon newPokemon, Integer id) {
		return pokemonRepository.findById(id)
			.map(pokemon -> {
				pokemon = new Pokemon(newPokemon);
				return pokemonRepository.save(pokemon);
			})
			.orElseThrow(() -> new EntityNotFoundException("pokemon", id));
	}
	
	public Skill createNewSkill(Skill newSkill) {
		return skillRepository.save(newSkill);
	}
	
	public void deleteSkill(Integer id) {
		skillRepository.deleteById(id);
	}
	
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
	
	public Skill getSkillById(Integer id) {
		return skillRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("skill", id));
	}	
	
	public Species createNewSpecies(Species newSpecies) {
		return speciesRepository.save(newSpecies);
	}
	
	public List<Species> getAllSpecies() {
		return speciesRepository.findByOrderByNameAsc();
	}
	
	public Species getSpeciesByName(String name) {
		
		return Optional.of(speciesRepository.findByName(name))
				.orElseThrow(() -> new EntityNotFoundException("species", name));
	}
	
	public void deleteSpecies(Integer id) {
		speciesRepository.deleteById(id);
	}
	
	public PokemonType createNewPokemonType(PokemonType newType) {
		return pokemonTypeRepository.save(newType);
	}
	
	public void deletePokemonType(Integer id) {
		pokemonTypeRepository.deleteById(id);
	}
	
	public List<PokemonType> getAllPokemonTypes() {
		return pokemonTypeRepository.findByOrderByNameAsc();
	}
	
	public PokemonType getTipoDePokemonById(Integer id) {
		return pokemonTypeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("tipo de pokemon", id));
	}
}
