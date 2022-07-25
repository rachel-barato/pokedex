package com.rgama.worldweather.handler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHandler {
	
	public String retrieveWeatherData(String city) {
		String convertedCity = city.replaceAll(" ", "%20");
		
		var request = HttpRequest
				.newBuilder(
					URI.create(
						"https://api.openweathermap.org/data/2.5/weather?q=" 
						+ convertedCity + 
						"&appid=5c5027876d78844b3a8ae65329c66296&units=metric&lang=pt_br"
					)
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
