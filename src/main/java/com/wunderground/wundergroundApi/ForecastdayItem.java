package com.wunderground.wundergroundApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ForecastdayItem{

	@JsonProperty("date")
	private Date date;

	@JsonProperty("icon_url")
	private String iconUrl;

	@JsonProperty("period")
	private int period;

	@JsonProperty("maxhumidity")
	private int maxhumidity;

	@JsonProperty("skyicon")
	private String skyicon;

	@JsonProperty("avewind")
	private Avewind avewind;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("avehumidity")
	private int avehumidity;

	@JsonProperty("snow_allday")
	private SnowAllday snowAllday;

	@JsonProperty("qpf_day")
	private QpfDay qpfDay;

	@JsonProperty("maxwind")
	private Maxwind maxwind;

	@JsonProperty("pop")
	private int pop;

	@JsonProperty("qpf_night")
	private QpfNight qpfNight;

	@JsonProperty("high")
	private High high;

	@JsonProperty("minhumidity")
	private int minhumidity;

	@JsonProperty("low")
	private Low low;

	@JsonProperty("snow_night")
	private SnowNight snowNight;

	@JsonProperty("snow_day")
	private SnowDay snowDay;

	@JsonProperty("conditions")
	private String conditions;

	@JsonProperty("qpf_allday")
	private QpfAllday qpfAllday;

	public void setDate(Date date){
		this.date = date;
	}

	public Date getDate(){
		return date;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setPeriod(int period){
		this.period = period;
	}

	public int getPeriod(){
		return period;
	}

	public void setMaxhumidity(int maxhumidity){
		this.maxhumidity = maxhumidity;
	}

	public int getMaxhumidity(){
		return maxhumidity;
	}

	public void setSkyicon(String skyicon){
		this.skyicon = skyicon;
	}

	public String getSkyicon(){
		return skyicon;
	}

	public void setAvewind(Avewind avewind){
		this.avewind = avewind;
	}

	public Avewind getAvewind(){
		return avewind;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setAvehumidity(int avehumidity){
		this.avehumidity = avehumidity;
	}

	public int getAvehumidity(){
		return avehumidity;
	}

	public void setSnowAllday(SnowAllday snowAllday){
		this.snowAllday = snowAllday;
	}

	public SnowAllday getSnowAllday(){
		return snowAllday;
	}

	public void setQpfDay(QpfDay qpfDay){
		this.qpfDay = qpfDay;
	}

	public QpfDay getQpfDay(){
		return qpfDay;
	}

	public void setMaxwind(Maxwind maxwind){
		this.maxwind = maxwind;
	}

	public Maxwind getMaxwind(){
		return maxwind;
	}

	public void setPop(int pop){
		this.pop = pop;
	}

	public int getPop(){
		return pop;
	}

	public void setQpfNight(QpfNight qpfNight){
		this.qpfNight = qpfNight;
	}

	public QpfNight getQpfNight(){
		return qpfNight;
	}

	public void setHigh(High high){
		this.high = high;
	}

	public High getHigh(){
		return high;
	}

	public void setMinhumidity(int minhumidity){
		this.minhumidity = minhumidity;
	}

	public int getMinhumidity(){
		return minhumidity;
	}

	public void setLow(Low low){
		this.low = low;
	}

	public Low getLow(){
		return low;
	}

	public void setSnowNight(SnowNight snowNight){
		this.snowNight = snowNight;
	}

	public SnowNight getSnowNight(){
		return snowNight;
	}

	public void setSnowDay(SnowDay snowDay){
		this.snowDay = snowDay;
	}

	public SnowDay getSnowDay(){
		return snowDay;
	}

	public void setConditions(String conditions){
		this.conditions = conditions;
	}

	public String getConditions(){
		return conditions;
	}

	public void setQpfAllday(QpfAllday qpfAllday){
		this.qpfAllday = qpfAllday;
	}

	public QpfAllday getQpfAllday(){
		return qpfAllday;
	}

	@Override
 	public String toString(){
		return 
			"ForecastdayItem{" + 
			"date = '" + date + '\'' + 
			",icon_url = '" + iconUrl + '\'' + 
			",period = '" + period + '\'' + 
			",maxhumidity = '" + maxhumidity + '\'' + 
			",skyicon = '" + skyicon + '\'' + 
			",avewind = '" + avewind + '\'' + 
			",icon = '" + icon + '\'' + 
			",avehumidity = '" + avehumidity + '\'' + 
			",snow_allday = '" + snowAllday + '\'' + 
			",qpf_day = '" + qpfDay + '\'' + 
			",maxwind = '" + maxwind + '\'' + 
			",pop = '" + pop + '\'' + 
			",qpf_night = '" + qpfNight + '\'' + 
			",high = '" + high + '\'' + 
			",minhumidity = '" + minhumidity + '\'' + 
			",low = '" + low + '\'' + 
			",snow_night = '" + snowNight + '\'' + 
			",snow_day = '" + snowDay + '\'' + 
			",conditions = '" + conditions + '\'' + 
			",qpf_allday = '" + qpfAllday + '\'' + 
			"}";
		}
}