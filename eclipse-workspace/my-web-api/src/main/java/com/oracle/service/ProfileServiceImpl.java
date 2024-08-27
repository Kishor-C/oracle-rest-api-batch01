package com.oracle.service;

import java.util.List;

import com.oracle.beans.Profile;
import com.oracle.dao.ProfileDao;
import com.oracle.dao.ProfileDaoImpl;
import com.oracle.dao.ProfileDaoJdbcImpl;
import com.oracle.exceptions.ProfileNotFoundException;

public class ProfileServiceImpl {
	// we need dao layer object
	private ProfileDao dao;
	// once the service object is created, dao object is also created
	public ProfileServiceImpl() {
		dao = new ProfileDaoJdbcImpl();
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
	// create a method that throws ProfileNotFoundException or returns a profile object
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		Profile profile = dao.findById(id);
		if(profile == null) {
			throw new ProfileNotFoundException("Profile with an id "+id+" not found");
		}
		return profile;
	}
}
