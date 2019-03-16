package com.ssh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		System.err.println("正在转换中......请稍后。。。。");
		if(source == null){
			return null;
		}else if(source.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(source);
			} catch (ParseException e){
				e.printStackTrace();
			}
		}else{
			throw new IllegalArgumentException("格式错误......");
		}
		return null;
	}

}
