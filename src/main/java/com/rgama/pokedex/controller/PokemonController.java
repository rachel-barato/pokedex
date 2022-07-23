package com.rgama.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgama.pokedex.model.Pokemon;
import com.rgama.pokedex.service.PokemonService;

@RestController
@RequestMapping(path="/pokemons")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@PostMapping()
	public ResponseEntity<Pokemon> createNewPokemon(@RequestBody Pokemon newPokemon) {
		return ResponseEntity.ok(pokemonService.createNewPokemon(newPokemon));
	}
	
	@GetMapping()
	public ResponseEntity<List<Pokemon>> getAllPokemons() {
		return ResponseEntity.ok(pokemonService.getAllPokemons());
	}	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deletePokemon(@PathVariable Integer id) {
		pokemonService.deletePokemon(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) {
		return ResponseEntity.ok(pokemonService.getPokemonById(id));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Pokemon> replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Integer id) {
		return ResponseEntity.ok(pokemonService.replacePokemon(newPokemon, id));
	}
}
