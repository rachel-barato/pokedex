package com.rgama.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgama.pokedex.PokedexService;
import com.rgama.pokedex.pokemonType.PokemonType;
import com.rgama.pokedex.skill.Skill;
import com.rgama.pokedex.species.Species;

@RestController
@RequestMapping(path="/pokedex")
public class PokedexController {
	
	@Autowired
	private PokedexService pokedexService;
	
	PokedexController(PokedexService pokedexService) {
		this.pokedexService = pokedexService;
	}

	
	@PostMapping(path="/skills")
	public ResponseEntity<Skill> createNewSkill(@RequestBody Skill newSkill) {
		return ResponseEntity.ok(pokedexService.createNewSkill(newSkill));
	}
	
	@GetMapping(path="/skills")
	public ResponseEntity<List<Skill>> getAllSkills() {
		return ResponseEntity.ok(pokedexService.getAllSkills());
	}
	
	@DeleteMapping(path="/skills/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable Integer id) {
		pokedexService.deleteSkill(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/skills/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Integer id) {
		return ResponseEntity.ok(pokedexService.getSkillById(id));
	}

	@RequestMapping(value = "/species", method = RequestMethod.POST, produces="application/json",  consumes="application/json")
	@PostMapping(path="/species")
	public ResponseEntity<Species> createNewSpecies(@RequestBody Species newSpecies) {
		return ResponseEntity.ok(pokedexService.createNewSpecies(newSpecies));
	}
	
	@GetMapping(path="/species")
	public ResponseEntity<List<Species>> getAllSpecies() {
		return ResponseEntity.ok(pokedexService.getAllSpecies());
	}
	
	@GetMapping(path="/species/{name}")
	public ResponseEntity<Species> getSpeciesByName(@PathVariable String name) {
		return ResponseEntity.ok(pokedexService.getSpeciesByName(name));
	}
	
	@DeleteMapping(path="/species/{id}")
	public ResponseEntity<String> deleteSpecies(Integer id) {
		pokedexService.deleteSpecies(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path="/types")
	public ResponseEntity<PokemonType> createNewPokemonType(@RequestBody PokemonType newType) {
		return ResponseEntity.ok(pokedexService.createNewPokemonType(newType));
	}
	
	@GetMapping(path="/types")
	public ResponseEntity<List<PokemonType>> getAllPokemonTypes() {
		return ResponseEntity.ok(pokedexService.getAllPokemonTypes());
	}
	
	@DeleteMapping(path="/types/{id}")
	public ResponseEntity<String> deletePokemonType(@PathVariable Integer id) {
		pokedexService.deletePokemonType(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/tipos/{id}")
	public ResponseEntity<PokemonType> getTipoDePokemonById(@PathVariable Integer id) {
		return ResponseEntity.ok(pokedexService.getTipoDePokemonById(id));
	}
}
