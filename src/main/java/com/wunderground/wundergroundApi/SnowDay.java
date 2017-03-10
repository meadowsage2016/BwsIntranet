package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SnowDay{

	@JsonProperty("in")
	private Object in;

	@JsonProperty("cm")
	private Object cm;

	public void setIn(Object in){
		this.in = in;
	}

	public Object getIn(){
		return in;
	}

	public void setCm(Object cm){
		this.cm = cm;
	}

	public Object getCm(){
		return cm;
	}

	@Override
 	public String toString(){
		return 
			"SnowDay{" + 
			"in = '" + in + '\'' + 
			",cm = '" + cm + '\'' + 
			"}";
		}
}