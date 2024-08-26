package com.oracle.beans;

import java.time.LocalDate;

public class Profile {
	private int profileId;
	private String name;
	private String password;
	private LocalDate dob;
	private long phone;
	// 2 constructors(default & parameterized), setters, getters
	public Profile(int profileId, String name, String password, LocalDate dob, long phone) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
