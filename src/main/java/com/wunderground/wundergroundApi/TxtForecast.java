package com.wunderground.wundergroundApi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TxtForecast{

	@JsonProperty("date")
	private String date;

	@JsonProperty("forecastday")
	private List<ForecastdayItem> forecastday;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setForecastday(List<ForecastdayItem> forecastday){
		this.forecastday = forecastday;
	}

	public List<ForecastdayItem> getForecastday(){
		return forecastday;
	}

	@Override
 	public String toString(){
		return 
			"TxtForecast{" + 
			"date = '" + date + '\'' + 
			",forecastday = '" + forecastday + '\'' + 
			"}";
		}
}