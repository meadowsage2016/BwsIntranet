package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Date{

	@JsonProperty("tz_short")
	private String tzShort;

	@JsonProperty("pretty")
	private String pretty;

	@JsonProperty("ampm")
	private String ampm;

	@JsonProperty("year")
	private int year;

	@JsonProperty("isdst")
	private String isdst;

	@JsonProperty("weekday")
	private String weekday;

	@JsonProperty("weekday_short")
	private String weekdayShort;

	@JsonProperty("epoch")
	private String epoch;

	@JsonProperty("sec")
	private int sec;

	@JsonProperty("min")
	private String min;

	@JsonProperty("month")
	private int month;

	@JsonProperty("hour")
	private int hour;

	@JsonProperty("monthname_short")
	private String monthnameShort;

	@JsonProperty("monthname")
	private String monthname;

	@JsonProperty("tz_long")
	private String tzLong;

	@JsonProperty("yday")
	private int yday;

	@JsonProperty("day")
	private int day;

	public void setTzShort(String tzShort){
		this.tzShort = tzShort;
	}

	public String getTzShort(){
		return tzShort;
	}

	public void setPretty(String pretty){
		this.pretty = pretty;
	}

	public String getPretty(){
		return pretty;
	}

	public void setAmpm(String ampm){
		this.ampm = ampm;
	}

	public String getAmpm(){
		return ampm;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setIsdst(String isdst){
		this.isdst = isdst;
	}

	public String getIsdst(){
		return isdst;
	}

	public void setWeekday(String weekday){
		this.weekday = weekday;
	}

	public String getWeekday(){
		return weekday;
	}

	public void setWeekdayShort(String weekdayShort){
		this.weekdayShort = weekdayShort;
	}

	public String getWeekdayShort(){
		return weekdayShort;
	}

	public void setEpoch(String epoch){
		this.epoch = epoch;
	}

	public String getEpoch(){
		return epoch;
	}

	public void setSec(int sec){
		this.sec = sec;
	}

	public int getSec(){
		return sec;
	}

	public void setMin(String min){
		this.min = min;
	}

	public String getMin(){
		return min;
	}

	public void setMonth(int month){
		this.month = month;
	}

	public int getMonth(){
		return month;
	}

	public void setHour(int hour){
		this.hour = hour;
	}

	public int getHour(){
		return hour;
	}

	public void setMonthnameShort(String monthnameShort){
		this.monthnameShort = monthnameShort;
	}

	public String getMonthnameShort(){
		return monthnameShort;
	}

	public void setMonthname(String monthname){
		this.monthname = monthname;
	}

	public String getMonthname(){
		return monthname;
	}

	public void setTzLong(String tzLong){
		this.tzLong = tzLong;
	}

	public String getTzLong(){
		return tzLong;
	}

	public void setYday(int yday){
		this.yday = yday;
	}

	public int getYday(){
		return yday;
	}

	public void setDay(int day){
		this.day = day;
	}

	public int getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"Date{" + 
			"tz_short = '" + tzShort + '\'' + 
			",pretty = '" + pretty + '\'' + 
			",ampm = '" + ampm + '\'' + 
			",year = '" + year + '\'' + 
			",isdst = '" + isdst + '\'' + 
			",weekday = '" + weekday + '\'' + 
			",weekday_short = '" + weekdayShort + '\'' + 
			",epoch = '" + epoch + '\'' + 
			",sec = '" + sec + '\'' + 
			",min = '" + min + '\'' + 
			",month = '" + month + '\'' + 
			",hour = '" + hour + '\'' + 
			",monthname_short = '" + monthnameShort + '\'' + 
			",monthname = '" + monthname + '\'' + 
			",tz_long = '" + tzLong + '\'' + 
			",yday = '" + yday + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}