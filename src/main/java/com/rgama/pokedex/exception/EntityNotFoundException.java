package com.rgama.pokedex.exception;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	
	public EntityNotFoundException(String tipeOfEntity, Integer id) {
		super("Could not find " + tipeOfEntity + " with id: " + id);
	}
	
	public EntityNotFoundException(String tipeOfEntity, String name) {
		super("Could not find " + tipeOfEntity + " with name: " + name);
	}

}
