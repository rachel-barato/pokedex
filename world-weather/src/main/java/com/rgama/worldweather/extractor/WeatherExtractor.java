package com.rgama.worldweather.extractor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgama.worldweather.model.Weather;

public class WeatherExtractor {
	
	public Weather weatherExtractor(String json) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, Weather.class);
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
