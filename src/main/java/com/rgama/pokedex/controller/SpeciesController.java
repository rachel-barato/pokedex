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

import com.rgama.pokedex.model.Species;
import com.rgama.pokedex.service.SpeciesService;

@RestController
@RequestMapping(path="/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;

	@PostMapping()
	public ResponseEntity<Species> createNewSpecies(@RequestBody Species newSpecies) {
		return ResponseEntity.ok(speciesService.createNewSpecies(newSpecies));
	}
	
	@GetMapping()
	public ResponseEntity<List<Species>> getAllSpecies() {
		return ResponseEntity.ok(speciesService.getAllSpecies());
	}
	
	@GetMapping(path="/{name}")
	public ResponseEntity<Species> getSpeciesByName(@PathVariable String name) {
		return ResponseEntity.ok(speciesService.getSpeciesByName(name));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deleteSpecies(Integer id) {
		speciesService.deleteSpecies(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
