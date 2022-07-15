package com.rgama.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokedexService<T> {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<Especie> getAllEspecies() {
		return especieRepository.findByOrderByEspecieAsc();
	}
	
	public ResponseEntity<Especie> getEspecieByName(String nome) {
		
		if(!nome.isEmpty()) {
			return ResponseEntity.ok(especieRepository.findByEspecie(nome));	
		}
		
		throw new EspecieNotFoundException(nome);
	}
	
	public ResponseEntity<T> deleteEspecie(Integer id) {
		especieRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon getPokemonById(Integer id) {
		return pokemonRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException(id));
	}
	
	public void deletePokemon(Integer id) {
		pokemonRepository.deleteById(id);
	}
	
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
}
