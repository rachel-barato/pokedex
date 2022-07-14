package com.rgama.pokedex;

@SuppressWarnings("serial")
public class PokemonNotFoundException extends RuntimeException {
	
	PokemonNotFoundException(Integer id) {
		super("Could not find pokemon " + id);
	}

}
