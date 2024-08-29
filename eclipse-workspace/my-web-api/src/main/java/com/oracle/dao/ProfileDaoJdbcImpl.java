package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.jdbc.ClientDriver;

import com.oracle.beans.Profile;

public class ProfileDaoJdbcImpl implements ProfileDao {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(ClientDriver.class.getName()); // load the jdbc driver for derby database
		String url = "jdbc:derby://localhost:1527/ofs_db";
		String username = "admin";
		String password = "admin";
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	@Override
	public Profile save(Profile profile) {
		Profile createdProfile = null;
		try {
			String sequenceQuery = "values(next value for profile_seq)";
			String insertQuery = "insert into profile values(?,?,?,?,?)";
			Connection con = getConnection();
			PreparedStatement pstmt1 = con.prepareStatement(sequenceQuery);
			ResultSet result = pstmt1.executeQuery(); // a result having a sequence number in the 1st column
			int id = 0;
			result.next();
			id = result.getInt(1);
			result.close();
			pstmt1.close();
			//statement for insert query
			PreparedStatement pstmt2 = con.prepareStatement(insertQuery);
			pstmt2.setInt(1, id); // 1st ? gets the sequence number
			pstmt2.setString(2, profile.getName()); // 2nd ? gets the name of the profile object
			pstmt2.setString(3, profile.getPassword());
			pstmt2.setLong(4, profile.getPhone());
			pstmt2.setDate(5, java.sql.Date.valueOf(profile.getDob()));
			// executeUpdate is used to run insert, update & delete queries
			pstmt2.executeUpdate();
			// pass the sequence and get the stored profile
			createdProfile = findById(id);
			pstmt2.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return createdProfile;
	}

	@Override
	public List<Profile> findAll() {
		List<Profile> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			String query = "select * from profile";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Profile pr = new Profile(); // { profileId=0, name=null, password=null,dob=null,phone=0}
				pr.setProfileId(result.getInt(1)); // {profileId=100, name=, passowrd=,dob=,phone..}
				pr.setName(result.getString(2)); // {profileId=100,name=Alex
				pr.setPassword(result.getString(3));
				pr.setPhone(result.getLong(4));
				pr.setDob(result.getDate(5).toLocalDate());
				list.add(pr);
				
			}
			result.close();
			statement.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Profile findById(int id) {
		Profile profileObject = null;
		// search by id in the db goes here
		String query = "select * from profile where profile_id=?";
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(query);
			// setting values to the ? using setType of PreparedStatement i.e., setInt, setString, setDob & so on
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				profileObject = new Profile();
				profileObject.setProfileId(result.getInt(1));
				profileObject.setName(result.getString(2));
				profileObject.setPassword(result.getString(3));
				profileObject.setPhone(result.getLong(4));
				profileObject.setDob(result.getDate(5).toLocalDate());
			}
			result.close();
			statement.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return profileObject;
	}

	@Override
	public Profile update(Profile profile) {
		String updateQuery = "update profile set name=?,password=?,phone=?,dob=? where profile_id=?";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, profile.getName());
			pstmt.setString(2, profile.getPassword());
			pstmt.setLong(3, profile.getPhone());;
			pstmt.setDate(4, java.sql.Date.valueOf(profile.getDob()));
			pstmt.setInt(5, profile.getProfileId());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return findById(profile.getProfileId());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
