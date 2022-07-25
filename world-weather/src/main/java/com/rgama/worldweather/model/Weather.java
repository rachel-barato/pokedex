package com.rgama.worldweather.model;

public class Weather {
	
	private String climate;
	
	private Double temperature;

	public Weather() {
	}

	public Weather(String climate, Double temperature) {
		this.climate = climate;
		this.temperature = temperature;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
}
