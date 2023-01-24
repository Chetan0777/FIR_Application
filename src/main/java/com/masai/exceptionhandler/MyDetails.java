package com.masai.exceptionhandler;

import java.time.LocalDate;

public class MyDetails {
	private String name;
	private LocalDate localDate;
	public MyDetails(String name, LocalDate localDate) {
	
		this.name = name;
		this.localDate = localDate;
	}
	public MyDetails() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

}
