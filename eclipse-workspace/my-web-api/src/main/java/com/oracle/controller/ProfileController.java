package com.oracle.controller;

import java.util.List;

import com.oracle.beans.Profile;
import com.oracle.exceptions.ProfileNotFoundException;
import com.oracle.service.ProfileServiceImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//http://ip:port/application-name/webapi/v1
@Path("/v1")
public class ProfileController {
	// controller needs service object
	private ProfileServiceImpl service;
	public ProfileController() {
		service = new ProfileServiceImpl();
	}

	// updating the phone by id
	@PUT
	@Path("/update/phone/{id}/{phone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePhone(@PathParam("id") int id, @PathParam("phone") long phone) throws ProfileNotFoundException {
		Profile p = service.updatePhoneById(id, phone);
		return Response.status(200).entity(p).build();
	}
	// updating the password by id
	@PUT
	@Path("/update/password/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePassword(@PathParam("id") int id, @PathParam("password") String password) throws ProfileNotFoundException {
		Profile p = service.updatePasswordById(id, password);
		return Response.status(200).entity(p).build();
	}
	
	@GET
	@Path("/secured")
	@Produces(MediaType.TEXT_PLAIN)
	public Response securedResource() {
		return Response.status(200).entity("Welcome to secured resource").build();
	}
	
	
	
	// invoke fetchProfile by passing the id through path param
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/profile/{id}")
	public Response getProfile(@PathParam("id") int profileId) throws ProfileNotFoundException {
		Profile profile = service.fetchProfile(profileId);
		return Response.status(200).entity(profile).build();
	}
	
	// we need to use Response as a return type in Restful webservice
	
	@POST // call this webservice with HTTP POST
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON) // produces json data from the response body
	@Consumes(MediaType.APPLICATION_JSON) // consumes json data from the request body
	public Response create(Profile p) {
		Profile profile2 = service.store(p);
		// Response object can takes status code and body of the response build creates a response object
		return Response.status(201).entity(profile2).build();
	}
	
	// a webservice to get all the profiles in JSON format
	@GET
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfiles() {
		List<Profile> list = service.fetchProfiles();
		return Response.status(200).entity(list).build();
	}
	
	
	@Path("/welcome")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome() {
		return "Hello REST webservice";
	}
	//welcome/Kishor [or] welcome/Ravi [or] welcome/Shubham
	@Path("/welcome/{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome(@PathParam("name") String name) {
		return "Welcome "+name;
	}
}
