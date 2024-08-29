package com.oracle.dao;

import java.util.List;

import com.oracle.beans.Profile;

public interface ProfileDao {

	// a store method which stores the profile object & can also generate id
	Profile save(Profile profile);

	// a find all method to return all the profiles
	List<Profile> findAll();

	// a find by id method to return a profile or null
	Profile findById(int id);
	
	// an update method that updates the Profile
	Profile update(Profile profile);

}