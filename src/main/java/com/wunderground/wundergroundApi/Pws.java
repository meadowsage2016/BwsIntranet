package com.wunderground.wundergroundApi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Pws{

	@JsonProperty("station")
	private List<StationItem> station;

	public void setStation(List<StationItem> station){
		this.station = station;
	}

	public List<StationItem> getStation(){
		return station;
	}

	@Override
 	public String toString(){
		return 
			"Pws{" + 
			"station = '" + station + '\'' + 
			"}";
		}
}