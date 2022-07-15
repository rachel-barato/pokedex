package com.rgama.pokedex;

@SuppressWarnings("serial")
public class EspecieNotFoundException extends RuntimeException {
	
	EspecieNotFoundException(String name) {
		super("Could not find especie " + name);
	}

}
