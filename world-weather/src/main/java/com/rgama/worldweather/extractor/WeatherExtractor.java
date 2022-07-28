package com.rgama.worldweather.extractor;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgama.worldweather.model.Weather;

public class WeatherExtractor {
	
	public Weather weatherExtractor(String json) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Weather weather = new Weather();
		
		JsonPointer cityNamePointer = JsonPointer.compile("/name");
		JsonPointer climatePointer = JsonPointer.compile("/weather/0/main");
		JsonPointer temperaturePointer = JsonPointer.compile("/main/temp");
		
		try {
			JsonNode jsonData = objectMapper.readTree(json);
			weather.setCityName(jsonData.at(cityNamePointer).asText());
			weather.setClimate(jsonData.at(climatePointer).asText());
			weather.setTemperature(jsonData.at(temperaturePointer).asDouble());
			
			return weather;
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
