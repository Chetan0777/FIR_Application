package com.masai.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FirDto {
	
	private String crimeDetail; 
	private LocalDateTime timeStamp;
	private String policeStation;
	List<UserDto> users=new ArrayList<>();
	public FirDto(String crimeDetail, LocalDateTime timeStamp, String policeStation, List<UserDto> users) {
		super();
		this.crimeDetail = crimeDetail;
		this.timeStamp = timeStamp;
		this.policeStation = policeStation;
		this.users = users;
	}
	public FirDto() {
		
	}
	public String getCrimeDetail() {
		return crimeDetail;
	}
	public void setCrimeDetail(String crimeDetail) {
		this.crimeDetail = crimeDetail;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public List<UserDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	
	

}
