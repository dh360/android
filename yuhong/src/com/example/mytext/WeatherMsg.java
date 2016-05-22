package com.example.mytext;

import android.app.Activity;

public class WeatherMsg  {
	private String cityName ;
	private String temp;
	private String day;
	private String week;
	private String weather;
	private String humidity;
	private String wind;
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	@Override
	public String toString() {
		return "WeatherMsg [cityName=" + cityName + ", temp=" + temp + ", day="
				+ day + ", week=" + week +", weather="+weather+", wind="
				+ wind + ", humidity="+ humidity +"]";
	}
	
	
}




