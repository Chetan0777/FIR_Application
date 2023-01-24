package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserLogin {
	@Id
	private Integer userId;
	@Column(unique = true)
	private String key;
	private LocalDate localDate;
	public UserLogin() {
		super();
	}
	public UserLogin(Integer userId, String key, LocalDate localDate) {
		super();
		this.userId = userId;
		this.key = key;
		this.localDate = localDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	
}
