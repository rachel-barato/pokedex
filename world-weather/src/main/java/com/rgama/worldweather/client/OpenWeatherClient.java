package com.rgama.worldweather.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@PropertySource("classpath:application.properties")
public class OpenWeatherClient {
	
	@Value("${weather.url}")
	private String url;
	
	public String retrieveWeatherData(String city) {
		
		URI uri = UriComponentsBuilder
				.fromUriString(url)
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
