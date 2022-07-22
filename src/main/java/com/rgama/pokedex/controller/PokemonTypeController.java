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
import org.springframework.web.bind.annotation.RestController;

import com.rgama.pokedex.model.PokemonType;
import com.rgama.pokedex.service.PokemonTypeService;

@RestController
@RequestMapping(path="/types")
public class PokemonTypeController {
	
	@Autowired
	private PokemonTypeService pokemonTypeService;
	
	@PostMapping()
	public ResponseEntity<PokemonType> createNewPokemonType(@RequestBody PokemonType newType) {
		return ResponseEntity.ok(pokemonTypeService.createNewPokemonType(newType));
	}
	
	@GetMapping()
	public ResponseEntity<List<PokemonType>> getAllPokemonTypes() {
		return ResponseEntity.ok(pokemonTypeService.getAllPokemonTypes());
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deletePokemonType(@PathVariable Integer id) {
		pokemonTypeService.deletePokemonType(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<PokemonType> getTipoDePokemonById(@PathVariable Integer id) {
		return ResponseEntity.ok(pokemonTypeService.getTipoDePokemonById(id));
	}
}
