package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Location{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("magic")
	private String magic;

	@JsonProperty("nearby_weather_stations")
	private NearbyWeatherStations nearbyWeatherStations;

	@JsonProperty("country")
	private String country;

	@JsonProperty("tz_short")
	private String tzShort;

	@JsonProperty("country_iso3166")
	private String countryIso3166;

	@JsonProperty("city")
	private String city;

	@JsonProperty("lon")
	private String lon;

	@JsonProperty("type")
	private String type;

	@JsonProperty("l")
	private String L;

	@JsonProperty("requesturl")
	private String requesturl;

	@JsonProperty("wuiurl")
	private String wuiurl;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("wmo")
	private String wmo;

	@JsonProperty("tz_long")
	private String tzLong;

	@JsonProperty("state")
	private String state;

	@JsonProperty("lat")
	private String lat;

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getZip(){
		return zip;
	}

	public void setMagic(String magic){
		this.magic = magic;
	}

	public String getMagic(){
		return magic;
	}

	public void setNearbyWeatherStations(NearbyWeatherStations nearbyWeatherStations){
		this.nearbyWeatherStations = nearbyWeatherStations;
	}

	public NearbyWeatherStations getNearbyWeatherStations(){
		return nearbyWeatherStations;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setTzShort(String tzShort){
		this.tzShort = tzShort;
	}

	public String getTzShort(){
		return tzShort;
	}

	public void setCountryIso3166(String countryIso3166){
		this.countryIso3166 = countryIso3166;
	}

	public String getCountryIso3166(){
		return countryIso3166;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLon(String lon){
		this.lon = lon;
	}

	public String getLon(){
		return lon;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setL(String L){
		this.L = L;
	}

	public String getL(){
		return L;
	}

	public void setRequesturl(String requesturl){
		this.requesturl = requesturl;
	}

	public String getRequesturl(){
		return requesturl;
	}

	public void setWuiurl(String wuiurl){
		this.wuiurl = wuiurl;
	}

	public String getWuiurl(){
		return wuiurl;
	}

	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	public String getCountryName(){
		return countryName;
	}

	public void setWmo(String wmo){
		this.wmo = wmo;
	}

	public String getWmo(){
		return wmo;
	}

	public void setTzLong(String tzLong){
		this.tzLong = tzLong;
	}

	public String getTzLong(){
		return tzLong;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"zip = '" + zip + '\'' + 
			",magic = '" + magic + '\'' + 
			",nearby_weather_stations = '" + nearbyWeatherStations + '\'' + 
			",country = '" + country + '\'' + 
			",tz_short = '" + tzShort + '\'' + 
			",country_iso3166 = '" + countryIso3166 + '\'' + 
			",city = '" + city + '\'' + 
			",lon = '" + lon + '\'' + 
			",type = '" + type + '\'' + 
			",l = '" + L + '\'' + 
			",requesturl = '" + requesturl + '\'' + 
			",wuiurl = '" + wuiurl + '\'' + 
			",country_name = '" + countryName + '\'' + 
			",wmo = '" + wmo + '\'' + 
			",tz_long = '" + tzLong + '\'' + 
			",state = '" + state + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}