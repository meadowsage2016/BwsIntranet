package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class High{

	@JsonProperty("celsius")
	private String celsius;

	@JsonProperty("fahrenheit")
	private String fahrenheit;

	public void setCelsius(String celsius){
		this.celsius = celsius;
	}

	public String getCelsius(){
		return celsius;
	}

	public void setFahrenheit(String fahrenheit){
		this.fahrenheit = fahrenheit;
	}

	public String getFahrenheit(){
		return fahrenheit;
	}

	@Override
 	public String toString(){
		return 
			"High{" + 
			"celsius = '" + celsius + '\'' + 
			",fahrenheit = '" + fahrenheit + '\'' + 
			"}";
		}
}