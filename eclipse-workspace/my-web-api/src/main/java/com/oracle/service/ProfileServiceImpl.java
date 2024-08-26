package com.oracle.service;

import java.util.List;

import com.oracle.beans.Profile;
import com.oracle.dao.ProfileDaoImpl;

public class ProfileServiceImpl {
	// we need dao layer object
	private ProfileDaoImpl dao;
	// once the service object is created, dao object is also created
	public ProfileServiceImpl() {
		dao = new ProfileDaoImpl();
	}
	// create methods that calls CRUD operations of dao
	public Profile store(Profile profile) {
		Profile savedProfile = dao.save(profile);
		return savedProfile;
	}
	// create a method to read all the profiles
	public List<Profile> fetchProfiles() {
		List<Profile> list = dao.findAll();
		return list; // returns all the profiles from the dao
	}
}
