package com.rgama.pokedex.weather.handler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherHandler {
	
	public String getWeatherOnCity(String city) {
		
		HttpRequest request = HttpRequest.newBuilder(
					URI.create("http://localhost:8081/weather/" + city)
				)
				.GET()
				.build();
		try {
			var client = HttpClient.newHttpClient();
			return client.send(request, BodyHandlers.ofString()).body();
			
		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}
}
