package com.rgama.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/pokedex")
public class PokedexController {
	
	@Autowired
	private PokedexService pokedexService;
	
	PokedexController(PokedexService pokedexService) {
		this.pokedexService = pokedexService;
	}
	
	@PostMapping(path="/pokemons")
	public @ResponseBody ResponseEntity<Pokemon> createNewPokemon(@RequestBody Pokemon newPokemon) {
		return pokedexService.createNewPokemon(newPokemon);
	}
	
	@GetMapping(path="/pokemons")
	public @ResponseBody List<Pokemon> getAllPokemons() {
		return pokedexService.getAllPokemons();
	}
	
	@DeleteMapping(path="/pokemons/{id}")
	public void deletePokemon(@PathVariable Integer id) {
		pokedexService.deletePokemon(id);
	}
	
	@GetMapping(path="/pokemons/{id}")
	public @ResponseBody Pokemon getPokemonById(@PathVariable Integer id) {
		return pokedexService.getPokemonById(id);
	}
	
	@PostMapping(path="/skills")
	public @ResponseBody ResponseEntity<Skill> createNewSkill(@RequestBody Skill newSkill) {
		return pokedexService.createNewSkill(newSkill);
	}
	
	@GetMapping(path="/skills")
	public @ResponseBody List<Skill> getAllSkills() {
		return pokedexService.getAllSkills();
	}
	
	@DeleteMapping(path="/skills/{id}")
	public @ResponseBody ResponseEntity<String> deleteSkill(@PathVariable Integer id) {
		return pokedexService.deleteSkill(id);
	}
	
	@GetMapping(path="/skills/{id}")
	public @ResponseBody Skill getSkillById(@PathVariable Integer id) {
		return pokedexService.getSkillById(id);
	}

	@RequestMapping(value = "/species", method = RequestMethod.POST, produces="application/json",  consumes="application/json")
	@PostMapping(path="/species")
	public @ResponseBody ResponseEntity<Species> createNewSpecies(@RequestBody Species newSpecies) {
		return pokedexService.createNewSpecies(newSpecies);
	}
	
	@GetMapping(path="/species")
	public @ResponseBody List<Species> getAllSpecies() {
		return pokedexService.getAllSpecies();
	}
	
	@GetMapping(path="/species/{nome}")
	public @ResponseBody Species getSpeciesByName(@PathVariable String name) {
		return pokedexService.getSpeciesByName(name);
	}
	
	@DeleteMapping(path="/species/{id}")
	public @ResponseBody ResponseEntity<String> deleteSpecies(Integer id) {
		return pokedexService.deleteSpecies(id);
	}
	
	@PostMapping(path="/tipos")
	public @ResponseBody ResponseEntity<PokemonType> createNewTipoDePokemon(@RequestBody PokemonType newTipo) {
		return pokedexService.createNewTipo(newTipo);
	}
	
	@GetMapping(path="/tipos")
	public @ResponseBody List<PokemonType> getAllTiposDePokemon() {
		return pokedexService.getAllTiposDePokemon();
	}
	
	@DeleteMapping(path="/tipos/{id}")
	public @ResponseBody ResponseEntity<String> deleteTipoDePokemon(@PathVariable Integer id) {
		return pokedexService.deleteTipoDePokemon(id);
	}
	
	@GetMapping(path="/tipos/{id}")
	public @ResponseBody PokemonType getTipoDePokemonById(@PathVariable Integer id) {
		return pokedexService.getTipoDePokemonById(id);
	}
}
