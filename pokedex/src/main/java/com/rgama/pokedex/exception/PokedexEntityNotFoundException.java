package com.rgama.pokedex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PokedexEntityNotFoundException extends RuntimeException {
	
	public PokedexEntityNotFoundException(String tipeOfEntity, Integer id) {
		super("Could not find " + tipeOfEntity + " with id: " + id);
	}
	
	public PokedexEntityNotFoundException(String tipeOfEntity, String name) {
		super("Could not find " + tipeOfEntity + " with name: " + name);
	}

}
