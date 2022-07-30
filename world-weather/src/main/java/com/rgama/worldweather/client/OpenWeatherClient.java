package com.rgama.worldweather.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.web.util.UriComponentsBuilder;

public class OpenWeatherClient {
	
	public String retrieveWeatherData(String city) {
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://api.openweathermap.org/data/2.5/weather")
				.queryParam("q", city)
				.queryParam("appid", System.getenv().get("apiId").toString())
				.queryParam("units","metric")
				.queryParam("lang","pt_br")
				.build().toUri();
		
		try {
			var client = HttpClient.newHttpClient();
			return client.send(
					HttpRequest.newBuilder(uri).GET().build(), 
					BodyHandlers.ofString()
				).body();
			
		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}

}
