package com.rgama.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.constant.PokemonType;
import com.rgama.pokedex.exception.PokedexEntityNotFoundException;
import com.rgama.pokedex.model.CityPokemons;
import com.rgama.pokedex.model.Pokemon;
import com.rgama.pokedex.model.Weather;
import com.rgama.pokedex.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private WeatherService weatherService;
	
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
	
	public CityPokemons getPokemonListbyWeather(String city) {
		Weather currentWeather = weatherService.getWeatherByCity(city);
		
		List<Pokemon> pokemonList = pokemonRepository
				.getPokemonBySpeciesPokemonTypesName(
						getPokemonTypeByWeather(currentWeather).toString()
				);
		
		return new CityPokemons(city, currentWeather, pokemonList);
	}
	
	private PokemonType getPokemonTypeByWeather(Weather currentWeather) {
		if(currentWeather.getClimate().contains("rain")) {
			return PokemonType.ELECTRIC;
		}
		return pokemonTypeByTemperatureRange(currentWeather.getTemperature());
	}
	
	private PokemonType pokemonTypeByTemperatureRange(Double temperature) {
		
		if(temperature < 5) {
			return PokemonType.ICE;
		}
		else if(temperature >= 5 || temperature < 10) {
			return PokemonType.WATER;
		}
		else if(temperature >= 12 || temperature < 15) {
			return PokemonType.GRASS;
		}
		else if(temperature >= 15 || temperature < 21) {
			return PokemonType.GROUND;
		}
		else if(temperature >= 23 || temperature < 27) {
			return PokemonType.BUG;
		}
		else if(temperature >= 27 || temperature <= 33) {
			return PokemonType.ROCK;
		}
		else if(temperature > 33) {
			return PokemonType.FIRE;
		}
		else return PokemonType.NORMAL; 
	}
	
	public List<Pokemon> getPokemonByPokemonType(String typeName) {
		return pokemonRepository.getPokemonBySpeciesPokemonTypesName(typeName);
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
