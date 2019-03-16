package com.ssh.vo.menu;

import java.sql.Date;

public class WeathersVO {
	private String date;//日期
	private String image ; //天气图片
	private String sunDownTime;//太阳下山时间
	private String sunRiseTime ; // 日出时间
	private String tempDayC ; // 日温度
	private String tempNightC;//夜温度
	private String weather;//天气状况
	private String week;//星期
	private String days;
	private String daysName;
	
	
	
	public String getDaysName() {
		return daysName;
	}
	public void setDaysName(String daysName) {
		this.daysName = daysName;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSunDownTime() {
		return sunDownTime;
	}
	public void setSunDownTime(String sunDownTime) {
		this.sunDownTime = sunDownTime;
	}
	public String getSunRiseTime() {
		return sunRiseTime;
	}
	public void setSunRiseTime(String sunRiseTime) {
		this.sunRiseTime = sunRiseTime;
	}
	public String getTempDayC() {
		return tempDayC;
	}
	public void setTempDayC(String tempDayC) {
		this.tempDayC = tempDayC;
	}
	public String getTempNightC() {
		return tempNightC;
	}
	public void setTempNightC(String tempNightC) {
		this.tempNightC = tempNightC;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public WeathersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeathersVO(String date, String image, String sunDownTime, String sunRiseTime, String tempDayC,
			String tempNightC, String weather, String week) {
		super();
		this.date = date;
		this.image = image;
		this.sunDownTime = sunDownTime;
		this.sunRiseTime = sunRiseTime;
		this.tempDayC = tempDayC;
		this.tempNightC = tempNightC;
		this.weather = weather;
		this.week = week;
	}
	@Override
	public String toString() {
		return "WeathersVO [date=" + date + ", image=" + image + ", sunDownTime=" + sunDownTime + ", sunRiseTime="
				+ sunRiseTime + ", tempDayC=" + tempDayC + ", tempNightC=" + tempNightC + ", weather=" + weather
				+ ", week=" + week + "]";
	}
	
}
