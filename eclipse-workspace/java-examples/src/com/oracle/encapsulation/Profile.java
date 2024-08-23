package com.oracle.encapsulation;

import java.time.LocalDate;

// a reusable class to maintain
// profile data: profileId, name, password, phone, dob
public class Profile {

	private int profileId;
	private String name;
	private String password;
	private long phone; // number must be suffixed with L 
	private LocalDate dob; // ISO format "yyyy-MM-dd"
	// Right Click -> Source -> Generate Constructors using fields: constructor to initialize the properties
	public Profile(int profileId, String name, String password, long phone, LocalDate dob) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
	}
	// most of the java frameworks creates object internally by using default constructor
	// Right Click -> Source -> Generate constructors from super class
	public Profile() {
		super();
	}
	// read & write methods for the properties - getters & setters
	// Right Click -> Source -> Generate Setters & Getters
	public int getProfileId() {
		return profileId;
	}
//	public void setProfileId(int profileId) {
//		this.profileId = profileId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
