package com.app.wru.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Id
	private Long userId; 
	@Column
	private String title;
	@Column
	private String customerName;
	@Column
	private String password;
	@Column
	private String profession;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String phoneNumber;
	@Column
	private String gender;
	@Column
	private String countryOfOrigin;
	@Column
	private String email;
	

	public Customer(Long userId, String title, String customerName, String password, String profession, String city,
			String state, String phoneNumber, String gender, String countryOfOrigin, String email) {
		super();
		this.userId = userId;
		this.title = title;
		this.customerName = customerName;
		this.password = password;
		this.profession = profession;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.countryOfOrigin = countryOfOrigin;
		this.email = email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [title=" + title + ", customerName=" + customerName + ", password=" + password + ", profession="
				+ profession + ", city=" + city + ", state=" + state + ", phoneNumber=" + phoneNumber + ", gender="
				+ gender + ", countryOfOrigin=" + countryOfOrigin + ", email=" + email + "]";
	}
	
	
	
	
	
	
	

}
