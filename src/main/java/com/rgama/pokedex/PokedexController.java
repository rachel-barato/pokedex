package com.rgama.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	private PokedexService<?> pokedexService;
	
	PokedexController(PokedexService<?> pokedexService) {
		this.pokedexService = pokedexService;
	}

	
	@GetMapping(path="/especies")
	public @ResponseBody List<Especie> getAllEspecies() {
		return pokedexService.getAllEspecies();
	}
	
	@GetMapping(path="/especies/{nome}")
	public @ResponseBody ResponseEntity<Especie> getEspecieByName(@PathVariable String nome) {
		return pokedexService.getEspecieByName(nome);
	}
	
	@DeleteMapping(path="/especies/{id}")
	public @ResponseBody void deleteEspecie(Integer id) {
		
	}
	
	@GetMapping(path="/pokemons")
	public @ResponseBody List<Pokemon> getAllPokemons() {
		return pokedexService.getAllPokemons();
	}
	
	@GetMapping(path="/pokemons/{id}")
	public @ResponseBody Pokemon getPokemonById(@PathVariable Integer id) {
		return pokedexService.getPokemonById(id);
	}
	
	@DeleteMapping(path="/pokemons/{id}")
	public void deletePokemon(@PathVariable Integer id) {
		pokedexService.deletePokemon(id);
	}
	
	@GetMapping(path="/skills")
	public @ResponseBody List<Skill> getAllSkills() {
		return pokedexService.getAllSkills();
	}
}
