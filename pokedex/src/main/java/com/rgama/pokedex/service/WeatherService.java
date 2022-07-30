package com.rgama.pokedex.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgama.pokedex.model.Weather;
import com.rgama.pokedex.weather.client.WeatherClient;

@Service
public class WeatherService {
	
	WeatherClient weatherHandler = new WeatherClient();

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
