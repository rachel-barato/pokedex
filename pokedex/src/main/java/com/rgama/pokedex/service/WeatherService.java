package com.rgama.pokedex.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgama.pokedex.model.Weather;
import com.rgama.pokedex.weather.handler.WeatherHandler;

@Service
public class WeatherService {
	
	WeatherHandler weatherHandler = new WeatherHandler();

	public Weather getWeatherByCity(String city) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper
						.readValue(
							weatherHandler.getWeatherOnCity(city), 
							Weather.class
						);
			
		}catch (JsonProcessingException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		  
		  
	}
}
