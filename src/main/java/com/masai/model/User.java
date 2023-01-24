package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String lastName ;
	@Column(unique = true)
	@Email(message =  "Email is not in 'example@email.com' format")
	private String email;
	@Size(min = 10, max = 12)
	@Column(unique = true)
	private Integer mobileNumber;
	private String address;  
	private Integer age;
	private String gender;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})",message="atleast contain 1 Numeric,1 special charecter or one lowercase 1uper leter and size must be 6 to 12")
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Fir> firs=new ArrayList<>();
	public User() {
		super();
	}
	public User(Integer userId, @Pattern(regexp = "^[a-zA-Z]*$") String firstName,
			@Pattern(regexp = "^[a-zA-Z]*$") String lastName,
			@Email(message = "Email is not in 'example@email.com' format") String email,
			@Size(min = 10, max = 12) Integer mobileNumber, String address, Integer age, String gender,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})", message = "atleast contain 1 Numeric,1 special charecter or one lowercase 1uper leter and size must be 6 to 12") String password,
			List<Fir> firs) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.firs = firs;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Fir> getFirs() {
		return firs;
	}
	public void setFirs(List<Fir> firs) {
		this.firs = firs;
	}

}
