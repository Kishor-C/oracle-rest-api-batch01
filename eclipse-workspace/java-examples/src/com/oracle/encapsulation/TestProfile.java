package com.oracle.encapsulation;

import java.time.LocalDate;

public class TestProfile {

	// main -> control + space
	public static void main(String[] args) {
		// LocalDate.parse("yyyy-MM-dd")
		// int x = 20;
		// Profile x = new Profile(...);
		Profile profile1 = new Profile(1234, "Rajesh", "raj@123", 99003334352L, LocalDate.parse("2000-10-25"));
		Profile profile2 = new Profile(45678, "Vinay", "vin@123", 87653334352L, LocalDate.parse("2001-11-25"));
		
		// to read and display the profile informations you call getters
		// sysout -> control + space
		System.out.println("Hello "+profile1.getName()+", your dob is : "+profile1.getDob());
		// updating the name
		profile1.setName("Raj");
		System.out.println("Hello "+profile1.getName()+", your dob is : "+profile1.getDob());
		System.out.println("Hello "+profile2.getName()+", your dob is : "+profile2.getDob());
		
	}

}
