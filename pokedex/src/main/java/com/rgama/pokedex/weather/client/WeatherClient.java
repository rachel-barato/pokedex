package com.rgama.pokedex.weather.client;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.util.UriComponentsBuilder;

@ConfigurationProperties(prefix="weather")
public class WeatherClient {

	private String weather;
	
	public String getWeatherOnCity(String city) {
		
		URI uri = UriComponentsBuilder
		.fromUriString(weather)
		.path(city)
		.build().toUri();
		
		try {
			var client = HttpClient.newHttpClient();
			return client.send(
						HttpRequest.newBuilder(uri).GET().build(), 
						BodyHandlers.ofString()
					).body();
			
		} catch (IOException | InterruptedException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
