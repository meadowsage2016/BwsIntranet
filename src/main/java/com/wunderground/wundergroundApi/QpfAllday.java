package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class QpfAllday{

	@JsonProperty("mm")
	private int mm;

	@JsonProperty("in")
	private double in;

	public void setMm(int mm){
		this.mm = mm;
	}

	public int getMm(){
		return mm;
	}

	public void setIn(double in){
		this.in = in;
	}

	public double getIn(){
		return in;
	}

	@Override
 	public String toString(){
		return 
			"QpfAllday{" + 
			"mm = '" + mm + '\'' + 
			",in = '" + in + '\'' + 
			"}";
		}
}