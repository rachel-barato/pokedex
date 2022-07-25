package com.rgama.pokedex.exception;

@SuppressWarnings("serial")
public class PokedexEntityNotFoundException extends RuntimeException {
	
	public PokedexEntityNotFoundException(String tipeOfEntity, Integer id) {
		super("Could not find " + tipeOfEntity + " with id: " + id);
	}
	
	public PokedexEntityNotFoundException(String tipeOfEntity, String name) {
		super("Could not find " + tipeOfEntity + " with name: " + name);
	}

}
