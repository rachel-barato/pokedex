package com.rgama.worldweather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgama.worldweather.client.OpenWeatherClient;
import com.rgama.worldweather.extractor.WeatherExtractor;
import com.rgama.worldweather.model.Weather;

@RestController
@RequestMapping(path="/weather")
public class WeatherController {
	
	private OpenWeatherClient clientHandler = new OpenWeatherClient();
	
	private WeatherExtractor weatherExtractor = new WeatherExtractor();
	
	@GetMapping(path="/{city}")
	public Weather getWeather(@PathVariable String city) {
		var response = clientHandler.retrieveWeatherData(city);
		return weatherExtractor.weatherExtractor(response);
	}

}
