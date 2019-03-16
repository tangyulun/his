package com.ssh.vo.menu;

import java.util.List;

public class CityVO {
	private String cityId ; // 城市ID
	private String cityName ; // 城市名
	private String provinceName ; //所属省份
	private List<WeathersVO> weathers;//天气信息
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public List<WeathersVO> getWeathers() {
		return weathers;
	}
	public void setWeathers(List<WeathersVO> weathers) {
		this.weathers = weathers;
	}
	public CityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityVO(String cityId, String cityName, String provinceName, List<WeathersVO> weathers) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceName = provinceName;
		this.weathers = weathers;
	}
	@Override
	public String toString() {
		return "CityVO [cityId=" + cityId + ", cityName=" + cityName + ", provinceName=" + provinceName + ", weathers="
				+ weathers + "]";
	}
	
}
