package com.rgama.pokedex.model;

public class Weather {
	
	private String cityName;
	
	private String climate;
	
	private Double temperature;

	public Weather() {
	}

	public Weather(String cityName, String climate, Double temperature) {
		this.cityName = cityName;
		this.climate = climate;
		this.temperature = temperature;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
