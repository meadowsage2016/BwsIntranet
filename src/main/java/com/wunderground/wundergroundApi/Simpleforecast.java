package com.wunderground.wundergroundApi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Simpleforecast{

	@JsonProperty("forecastday")
	private List<ForecastdayItem> forecastday;

	public void setForecastday(List<ForecastdayItem> forecastday){
		this.forecastday = forecastday;
	}

	public List<ForecastdayItem> getForecastday(){
		return forecastday;
	}

	@Override
 	public String toString(){
		return 
			"Simpleforecast{" + 
			"forecastday = '" + forecastday + '\'' + 
			"}";
		}
}