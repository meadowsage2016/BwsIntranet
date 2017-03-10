package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Forecast{

	@JsonProperty("simpleforecast")
	private Simpleforecast simpleforecast;

	@JsonProperty("txt_forecast")
	private TxtForecast txtForecast;

	public void setSimpleforecast(Simpleforecast simpleforecast){
		this.simpleforecast = simpleforecast;
	}

	public Simpleforecast getSimpleforecast(){
		return simpleforecast;
	}

	public void setTxtForecast(TxtForecast txtForecast){
		this.txtForecast = txtForecast;
	}

	public TxtForecast getTxtForecast(){
		return txtForecast;
	}

	@Override
 	public String toString(){
		return 
			"Forecast{" + 
			"simpleforecast = '" + simpleforecast + '\'' + 
			",txt_forecast = '" + txtForecast + '\'' + 
			"}";
		}
}