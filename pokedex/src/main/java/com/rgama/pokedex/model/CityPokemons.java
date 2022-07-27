package com.rgama.pokedex.model;

import java.util.List;

public class CityPokemons {

	private String city;
	
	private Weather currentWeather;
	
	private List<Pokemon> pokemonsList;

	public CityPokemons(String city, Weather currentWeather, List<Pokemon> pokemonsList) {
		this.city = city;
		this.currentWeather = currentWeather;
		this.pokemonsList = pokemonsList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
