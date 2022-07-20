package com.rgama.pokedex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private TipoDePokemonRepository tipoDePokemonRepository;
	
	public ResponseEntity<Pokemon> createNewPokemon(Pokemon newPokemon) {
		return  ResponseEntity.ok(pokemonRepository.save(newPokemon));
	}
	
	public List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon getPokemonById(Integer id) {
		return pokemonRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("pokemon", id));
	}
	
	public ResponseEntity<String> deletePokemon(Integer id) {
		pokemonRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<Skill> createNewSkill(Skill newSkill) {
		return ResponseEntity.ok(skillRepository.save(newSkill));
	}
	
	public ResponseEntity<String> deleteSkill(Integer id) {
		skillRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
	
	public Skill getSkillById(Integer id) {
		return skillRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("skill", id));
	}	
	
	public ResponseEntity<Species> createNewSpecies(Species newSpecies) {
		return ResponseEntity.ok(speciesRepository.save(newSpecies));
	}
	
	public List<Species> getAllSpecies() {
		return speciesRepository.findByOrderByNameAsc();
	}
	
	public Species getSpeciesByName(String name) {
		Optional<Species> speciesFound = Optional.of(speciesRepository.findBySpecies(name));
		
		return speciesFound.orElseThrow(() -> new EntityNotFoundException("species", name));
	}
	
	public ResponseEntity<String> deleteSpecies(Integer id) {
		speciesRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<TipoDePokemon> createNewTipo(TipoDePokemon newTipo) {
		return ResponseEntity.ok(tipoDePokemonRepository.save(newTipo));
	}
	
	public ResponseEntity<String> deleteTipoDePokemon(Integer id) {
		tipoDePokemonRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public List<TipoDePokemon> getAllTiposDePokemon() {
		return tipoDePokemonRepository.findByOrderByTipoAsc();
	}
	
	public TipoDePokemon getTipoDePokemonById(Integer id) {
		return tipoDePokemonRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("tipo de pokemon", id));
	}
}
