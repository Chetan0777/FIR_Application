package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Fir {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firId;
	private String crimeDetail; 
	private LocalDateTime timeStamp;
	private String policeStation;
	public Fir(Integer firId, String crimeDetail, LocalDateTime timeStamp, String policeStation) {
		super();
		this.firId = firId;
		this.crimeDetail = crimeDetail;
		this.timeStamp = timeStamp;
		this.policeStation = policeStation;
	}
	public Integer getFirId() {
		return firId;
	}
	public void setFirId(Integer firId) {
		this.firId = firId;
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
	public Fir() {
		super();
		
	}
	
}
