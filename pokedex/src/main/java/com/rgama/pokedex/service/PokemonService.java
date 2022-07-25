package com.rgama.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.PokedexEntityNotFoundException;
import com.rgama.pokedex.model.Pokemon;
import com.rgama.pokedex.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public Pokemon createNewPokemon(Pokemon newPokemon) {
		return  pokemonRepository.save(newPokemon);
	}
	
	public void deletePokemon(Integer id) {
		pokemonRepository.deleteById(id);
	}
	
	public List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	public Pokemon getPokemonById(Integer id) {
		return pokemonRepository.findById(id)
				.orElseThrow(() -> new PokedexEntityNotFoundException("pokemon", id));
	}
	
	public Pokemon replacePokemon(Pokemon newPokemon, Integer id) {
		return pokemonRepository.findById(id)
				.map(pokemon -> {
					pokemon = new Pokemon(newPokemon);
					return pokemonRepository.save(pokemon);
				})
				.orElseThrow(() -> new PokedexEntityNotFoundException("pokemon", id));
	}
}
