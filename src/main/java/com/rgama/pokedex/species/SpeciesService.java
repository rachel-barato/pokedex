package com.rgama.pokedex.species;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.PokedexEntityNotFoundException;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	public Species createNewSpecies(Species newSpecies) {
		return speciesRepository.save(newSpecies);
	}
	
	public List<Species> getAllSpecies() {
		return speciesRepository.findByOrderByNameAsc();
	}
	
	public Species getSpeciesByName(String name) {
		
		return Optional.of(speciesRepository.findByName(name))
				.orElseThrow(() -> new PokedexEntityNotFoundException("species", name));
	}
	
	public void deleteSpecies(Integer id) {
		speciesRepository.deleteById(id);
	}
}
