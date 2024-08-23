package com.oracle.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//http://ip:port/application-name/webapi/v1
@Path("/v1")
public class ProfileController {

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
