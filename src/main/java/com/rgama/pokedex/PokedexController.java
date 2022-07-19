package com.rgama.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@RequestMapping(value = "/especies", method = RequestMethod.POST, produces="application/json",  consumes="application/json")
	@PostMapping(path="/especies")
	public @ResponseBody ResponseEntity<Especie> createNewEspecie(@RequestBody Especie newEspecie) {
		return pokedexService.createNewEspecie(newEspecie);
	}
	
	@GetMapping(path="/especies")
	public @ResponseBody List<Especie> getAllEspecies() {
		return pokedexService.getAllEspecies();
	}
	
	@GetMapping(path="/especies/{nome}")
	public @ResponseBody Especie getEspecieByName(@PathVariable String nome) {
		return pokedexService.getEspecieByName(nome);
	}
	
	@DeleteMapping(path="/especies/{id}")
	public @ResponseBody ResponseEntity<String> deleteEspecie(Integer id) {
		return pokedexService.deleteEspecie(id);
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
	
	@PostMapping(path="/tipos")
	public @ResponseBody ResponseEntity<TipoDePokemon> createNewTipoDePokemon(@RequestBody TipoDePokemon newTipo) {
		return pokedexService.createNewTipo(newTipo);
	}
	
	@GetMapping(path="/tipos")
	public @ResponseBody List<TipoDePokemon> getAllTiposDePokemon() {
		return pokedexService.getAllTiposDePokemon();
	}
	
	@DeleteMapping(path="/tipos/{id}")
	public @ResponseBody ResponseEntity<String> deleteTipoDePokemon(@PathVariable Integer id) {
		return pokedexService.deleteTipoDePokemon(id);
	}
	
	@GetMapping(path="/tipos/{id}")
	public @ResponseBody TipoDePokemon getTipoDePokemonById(@PathVariable Integer id) {
		return pokedexService.getTipoDePokemonById(id);
	}
}
