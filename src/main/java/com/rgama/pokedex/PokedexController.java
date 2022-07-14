package com.rgama.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/pokedex")
public class PokedexController {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	PokedexController(PokemonRepository repository) {
		this.pokemonRepository = repository;
	}

	
	@GetMapping(path="/especies")
	public @ResponseBody List<Especie> getAllEspecies() {
		return especieRepository.findAll();
	}
	
	@GetMapping(path="/especies/{nome}")
	public @ResponseBody Especie getEspecieByName(@PathVariable String nome) {
		return especieRepository.findByEspecie(nome);
	}
	
	@GetMapping(path="/pokemons")
	public @ResponseBody List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	@GetMapping(path="/pokemons/{id}")
	public @ResponseBody Pokemon getPokemonById(@PathVariable Integer id) {
		return pokemonRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException(id));
	}
	
	@DeleteMapping(path="/pokemons/{id}")
	public void deletePokemon(@PathVariable Integer id) {
		pokemonRepository.deleteById(id);
	}
	
	@GetMapping(path="/skills")
	public @ResponseBody List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
}
