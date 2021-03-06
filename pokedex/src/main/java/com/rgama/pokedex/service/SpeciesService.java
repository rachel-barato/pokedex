package com.rgama.pokedex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.PokedexEntityNotFoundException;
import com.rgama.pokedex.model.Species;
import com.rgama.pokedex.repository.SpeciesRepository;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	public Species createNewSpecies(Species newSpecies) {
		return speciesRepository.save(newSpecies);
	}
	
	public void deleteSpecies(Integer id) {
		speciesRepository.deleteById(id);
	}
	
	public List<Species> getAllSpecies() {
		return speciesRepository.findByOrderByNameAsc();
	}
	
	public Species getSpeciesByName(String name) {
		return Optional.of(speciesRepository.findByName(name))
				.orElseThrow(() -> new PokedexEntityNotFoundException("species", name));
	}
	
	public Species replaceSpecies(Species newSpecies, Integer id) {
		return speciesRepository.findById(id)
				.map(species -> {
					species = new Species(newSpecies);
					return speciesRepository.save(newSpecies);
				})
				.orElseThrow(() -> new PokedexEntityNotFoundException("species", id));
	}
}
