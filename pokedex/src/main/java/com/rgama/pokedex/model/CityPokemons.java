package com.rgama.pokedex.model;

import java.util.List;

public class CityPokemons {
	
	private Weather currentWeather;
	
	private List<Pokemon> pokemonsList;

	public CityPokemons(Weather currentWeather, List<Pokemon> pokemonsList) {
		this.currentWeather = currentWeather;
		this.pokemonsList = pokemonsList;
	}

	public Weather getCurrentWeather() {
		return currentWeather;
	}

	public void setCurrentWeather(Weather currentWeather) {
		this.currentWeather = currentWeather;
	}

	public List<Pokemon> getPokemonsList() {
		return pokemonsList;
	}

	public void setPokemonsList(List<Pokemon> pokemonsList) {
		this.pokemonsList = pokemonsList;
	}
}
