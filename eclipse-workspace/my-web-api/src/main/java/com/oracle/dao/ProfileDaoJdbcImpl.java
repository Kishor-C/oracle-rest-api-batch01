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
		// TODO Auto-generated method stub
		return null;
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
				Profile pr = new Profile();
				pr.setProfileId(result.getInt(1));
				pr.setName(result.getString(2));
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
		// TODO Auto-generated method stub
		return null;
	}

}
