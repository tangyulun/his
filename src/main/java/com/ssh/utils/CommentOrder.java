package com.ssh.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ssh.vo.menu.CityVO;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.menu.WeathersVO;
import com.ssh.vo.staff.Other;

public class CommentOrder {	
	/**
	 * 生成所有的varchar2订单编号 ， 形式 如 YY-2018020700001
	 * @param list  所有的编号
	 * @param o 编号前缀，两位
	 * @return
	 */
	public static String commOrder(String str , String o){
		String f = new SimpleDateFormat("yyyyMMdd").format(new Date());
		Integer integer = null;
		if(str == null){
			return o +"-"+ f + "00001";
		}else{
			integer = Integer.parseInt(str.substring(11 , str.length()));
		}
		int length = Integer.toString(integer + 1).length();
		String string = "";
		if(length < 5){
			for (int i = 0; i < 5 - length; i++) {
				string +="0";
			}
		}
		return o +"-"+ f + string + Integer.toString(integer + 1);
	}
	
	
	/**
	 * 模糊查询单号的通用方法
	 * @return
	 */
	public static String dateLike(){
		String f = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return "%"+f+"%";
	}
	/**
	 * 处理字符串，转成集合
	 * @param str
	 * @return
	 */
	public static List<Long> dealString(String str){
		List<Long> list = new ArrayList<>();
		if(!"".equals(str)){
			String [] s = str.split(",");
			for (String l : s) {
				list.add(Long.parseLong(l));
			}
		}
		return list;
	}
	
	/**
	 * 日期转型成Date
	 * @param date
	 * @return
	 */
	public static Date StringToDate(String date){
			if(date != null){
				if(!"".equals(date)){
					try {
						return new SimpleDateFormat("yyyy-MM-dd").parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return null;
	}
	
	/**
	 * 获取星期一和星期天
	 * @param whatDay
	 * @return
	 */
	public static String week(int whatDay){
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(new Date());
		cal.setFirstDayOfWeek(GregorianCalendar.MONDAY);   // 设置一个星期的第一天为星期1，默认是星期日
		cal.set(GregorianCalendar.DAY_OF_WEEK,whatDay);
		String day =  simple.format(cal.getTime()); 
		return day;
	}
	
	/**
	 * 获取单独日期
	 * @param dates
	 * @return
	 */
	public static List<String> everyDay(Date monday , int start , int end){
	Date d = monday;
	List<String> list = new ArrayList<>();
	for (int i = start; i < end; i++) {
		Calendar c=Calendar.getInstance();
		c.setTime(monday);
		c.add(Calendar.DATE ,i);
		String str = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		int startWith = str.lastIndexOf("-");
		String number = str.substring(startWith + 1, str.length());
		c.setTime(d);
		list.add(number);
	}
	return list;
	}
	
	public static Other lNWeek(Date date , int last , int next){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE ,last);
		String monday = simple.format(c.getTime());
		c.add(Calendar.DATE ,next);
		String sunday = simple.format(c.getTime());
		return new Other(monday, sunday);
	}
	
    /**
     * 获取字符串的 MD5
     */
    public static String encode(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte messageDigest[] = md5.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", b));
            }
            return hexString.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    
    /** 
     *  
     * @Title: getMonDay 
     * @Description: TODO(根据指定日期获取当周周一) 
     * @param date 
     * @return date 
     */  

    public static final int N = 0;  
    
    public static Date getMonDayToDate(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
  
        // N：0-表示本周，1-表示下周，-1-表示上周  
        cal.add(Calendar.DATE, -1);  
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        cal.set(Calendar.DAY_OF_WEEK, -6);  
        return cal.getTime();  
    }  
    
    
	public static String weather(String cityId) throws IOException{ 
		if(cityId == null) {
			cityId = "101250301";
		}
		URL url = new URL("http://aider.meizu.com/app/weather/listWeather?cityIds="+cityId);  
		BufferedReader breader = new BufferedReader(new  
				InputStreamReader(url.openConnection().getInputStream(),"UTF-8"));  
		StringBuffer all = new StringBuffer();  
		String line = null;  
		System.err.println(breader.readLine()); 
		while((line = breader.readLine()) != null){  
			all.append(line);  
			line = breader.readLine();  
		}  
		breader.close(); 
		return all.toString();
	}
	
	
	/**
	 * 将天气格式转为vo
	 * @param request 
	 * @param cityId 
	 * @param args
	 */
	public static CityVO getWeatherVo(HttpServletRequest request, String cityId) {
		try {
			String str = weather(cityId);
			JSONArray value = JSON.parseArray(JSON.parseObject(str).getString("value"));
			//城市信息
			CityVO city = new CityVO();
			if(!value.isEmpty()) {
				city.setCityId(value.getJSONObject(0).getString("cityid"));
				city.setCityName(value.getJSONObject(0).getString("city"));
				city.setProvinceName(value.getJSONObject(0).getString("provinceName"));
	
				//天气信息
				JSONArray weather = JSON.parseArray(value.getJSONObject(0).getString("weathers"));
				List<WeathersVO> listW = new ArrayList<>();
				for (int i = 0; i < 3; i++) {
					//创建天气对象
					WeathersVO we = new WeathersVO();
					we.setDate(weather.getJSONObject(i).getString("date"));
					
					if(i == 0) {
						we.setDaysName("今");
					}
					if(i == 1) {
						we.setDaysName("明");
					}
					
					if(i == 2) {
						we.setDaysName("后");
					}
					
					we.setSunDownTime(weather.getJSONObject(i).getString("sun_down_time"));
					we.setSunRiseTime(weather.getJSONObject(i).getString("sun_rise_time"));
					we.setTempDayC(weather.getJSONObject(i).getString("temp_day_c"));
					we.setTempNightC(weather.getJSONObject(i).getString("temp_night_c"));
					we.setWeather(weather.getJSONObject(i).getString("weather"));
					we.setImage(image(we.getWeather() , request));
					we.setWeek(weather.getJSONObject(i).getString("week"));
					listW.add(we);
				}
				city.setWeathers(listW);
			}
			return city;
		} catch (IOException e) {
			return null;
		}
	}
	
	//判断返回的天气值，返回对应的图片
	public static String image(String weather, HttpServletRequest request) {
		String pathName = request.getContextPath();
		String str [] = new String[] {"晴" , "多云" , "阴" , "雨" , "阵雨" , "中雨" , "雷阵雨" , "小雨" , "大雨"};
		String image [] = new String [] {"images/tsp/晴.png" , "images/tsp/阴天.png" ,"images/tsp/阴.png" 
				, "images/tsp/下雨-白天.png" , "images/tsp/阵雨.png" , "images/tsp/中雨.png" ,
				"images/tsp/雷阵雨.png" , "images/tsp/小雨.png" , "images/tsp/中到大雨.png"
		};
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals(weather)) {
				System.err.println(pathName +"/"+ image[i]);
				return pathName +"/"+ image[i];
			}
		}
		return pathName +"/"+ "images/tsp/未知.png";
	}
}


