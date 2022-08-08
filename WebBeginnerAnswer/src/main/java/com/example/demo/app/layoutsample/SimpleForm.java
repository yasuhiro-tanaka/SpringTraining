package com.example.demo.app.layoutsample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SimpleForm {
	private String radio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDate_yyyyMMdd() {
		if(date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
