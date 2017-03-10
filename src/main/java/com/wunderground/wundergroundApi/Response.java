package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("response")
	private Response response;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("forecast")
	private Forecast forecast;

	@JsonProperty("current_observation")
	private CurrentObservation currentObservation;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setForecast(Forecast forecast){
		this.forecast = forecast;
	}

	public Forecast getForecast(){
		return forecast;
	}

	public void setCurrentObservation(CurrentObservation currentObservation){
		this.currentObservation = currentObservation;
	}

	public CurrentObservation getCurrentObservation(){
		return currentObservation;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"response = '" + response + '\'' + 
			",location = '" + location + '\'' + 
			",forecast = '" + forecast + '\'' + 
			",current_observation = '" + currentObservation + '\'' + 
			"}";
		}
}