package com.oracle.controller;

import java.util.HashMap;
import java.util.Map;

import com.oracle.exceptions.ProfileNotFoundException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProfileExceptionMapper implements ExceptionMapper<ProfileNotFoundException>{

	@Override
	public Response toResponse(ProfileNotFoundException exception) {
		// TODO Auto-generated method stub
		String message = exception.getMessage(); // returns the exception message
		String errorCode = "404";
		// we can use Map interface to create key value pairs, that can be converted to JSON
		Map<String, String> body = new HashMap<>();
		body.put("message", message); // put method adds key & value
		body.put("status", errorCode); // {"message":message, "status":"404"}
		return Response.status(404).entity(body).build();
	}

}
