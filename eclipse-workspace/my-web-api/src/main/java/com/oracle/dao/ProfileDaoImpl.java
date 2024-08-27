package com.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import com.oracle.beans.Profile;

public class ProfileDaoImpl implements ProfileDao {
	// we are going to use collection framework instead of real DB
	private static List<Profile> fakeDB = new ArrayList<>();
	// a store method which stores the profile object & can also generate id
	@Override
	public Profile save(Profile profile) {
		// generating the id
		profile.setProfileId(fakeDB.size() + 1);
		// call add() method of List to store in the ArrayList
		fakeDB.add(profile); // will be stored in the ArrayList
		return profile; // return the saved profile with id and other properties
	}
	// a find all method to return all the profiles
	@Override
	public List<Profile> findAll() {
		return fakeDB; // returns all the profiles in the ArrayList
	}
	
	// a find by id method to return a profile or null
	@Override
	public Profile findById(int id) {
		Profile pr = null;
		for(Profile p : fakeDB) {
			if(p.getProfileId() == id) {
				pr = p;
				break; // loop must stop if profile is found
			}
		}
		// after the loop we can return
		return pr;
	}
}
