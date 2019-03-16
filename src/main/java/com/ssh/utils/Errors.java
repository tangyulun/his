package com.ssh.utils;

import org.springframework.stereotype.Component;

@Component
public class Errors {
	//是否有错误
	private boolean isError;
	
	//错误提示信息
	private String eMessage;

	public boolean isError() {
		return isError;
	}

	public String geteMessage() {
		return eMessage;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public void seteMessage(String eMessage) {
		this.eMessage = eMessage;
	}

	public Errors(boolean isError, String eMessage) {
		super();
		this.isError = isError;
		this.eMessage = eMessage;
	}

	public Errors() {
		super();
	}

	public Errors(String eMessage) {
		super();
		this.eMessage = eMessage;
	}

	public Errors(boolean isError) {
		super();
		this.isError = isError;
	}
}
