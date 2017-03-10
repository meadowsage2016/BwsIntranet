package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Features{

	@JsonProperty("geolookup")
	private int geolookup;

	@JsonProperty("forecast")
	private int forecast;

	@JsonProperty("conditions")
	private int conditions;

	public void setGeolookup(int geolookup){
		this.geolookup = geolookup;
	}

	public int getGeolookup(){
		return geolookup;
	}

	public void setForecast(int forecast){
		this.forecast = forecast;
	}

	public int getForecast(){
		return forecast;
	}

	public void setConditions(int conditions){
		this.conditions = conditions;
	}

	public int getConditions(){
		return conditions;
	}

	@Override
 	public String toString(){
		return 
			"Features{" + 
			"geolookup = '" + geolookup + '\'' + 
			",forecast = '" + forecast + '\'' + 
			",conditions = '" + conditions + '\'' + 
			"}";
		}
}