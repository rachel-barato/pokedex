package com.rgama.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.PokedexEntityNotFoundException;
import com.rgama.pokedex.model.PokemonType;
import com.rgama.pokedex.repository.PokemonTypeRepository;

@Service
public class PokemonTypeService {
	
	@Autowired
	private PokemonTypeRepository pokemonTypeRepository;
	
	public PokemonType createNewPokemonType(PokemonType newType) {
		return pokemonTypeRepository.save(newType);
	}
	
	public void deletePokemonType(Integer id) {
		pokemonTypeRepository.deleteById(id);
	}
	
	public List<PokemonType> getAllPokemonTypes() {
		return pokemonTypeRepository.findByOrderByNameAsc();
	}
	
	public PokemonType getTipoDePokemonById(Integer id) {
		return pokemonTypeRepository.findById(id)
				.orElseThrow(() -> new PokedexEntityNotFoundException("tipo de pokemon", id));
	}
}
