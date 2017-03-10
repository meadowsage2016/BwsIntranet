package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SnowAllday{

	@JsonProperty("in")
	private double in;

	@JsonProperty("cm")
	private double cm;

	public void setIn(double in){
		this.in = in;
	}

	public double getIn(){
		return in;
	}

	public void setCm(double cm){
		this.cm = cm;
	}

	public double getCm(){
		return cm;
	}

	@Override
 	public String toString(){
		return 
			"SnowAllday{" + 
			"in = '" + in + '\'' + 
			",cm = '" + cm + '\'' + 
			"}";
		}
}