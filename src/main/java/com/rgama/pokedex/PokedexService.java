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
	private EspecieRepository especieRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private TipoDePokemonRepository tipoDePokemonRepository;

	
	public ResponseEntity<Especie> createNewEspecie(Especie newEspecie) {
		return ResponseEntity.ok(especieRepository.save(newEspecie));
	}
	
	public List<Especie> getAllEspecies() {
		return especieRepository.findByOrderByEspecieAsc();
	}
	
	public Especie getEspecieByName(String nome) {
		Optional<Especie> especieFound = Optional.of(especieRepository.findByEspecie(nome));
		
		return especieFound.orElseThrow(() -> new EntityNotFoundException("especie", nome));
	}
	
	public ResponseEntity<String> deleteEspecie(Integer id) {
		especieRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
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
