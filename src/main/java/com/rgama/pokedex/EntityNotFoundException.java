package com.rgama.pokedex;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	
	EntityNotFoundException(String tipeOfEntity, Integer id) {
		super("Could not find " + tipeOfEntity + " with id: " + id);
	}
	
	EntityNotFoundException(String tipeOfEntity, String name) {
		super("Could not find " + tipeOfEntity + " with name: " + name);
	}

}
