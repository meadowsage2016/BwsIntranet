package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NearbyWeatherStations{

	@JsonProperty("pws")
	private Pws pws;

	@JsonProperty("airport")
	private Airport airport;

	public void setPws(Pws pws){
		this.pws = pws;
	}

	public Pws getPws(){
		return pws;
	}

	public void setAirport(Airport airport){
		this.airport = airport;
	}

	public Airport getAirport(){
		return airport;
	}

	@Override
 	public String toString(){
		return 
			"NearbyWeatherStations{" + 
			"pws = '" + pws + '\'' + 
			",airport = '" + airport + '\'' + 
			"}";
		}
}