package com.oracle.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RequestInterceptor implements ContainerRequestFilter {

	// this method is called for every request that is sent to the webservice
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// we will hard-code the username & password such only authenticated users must be processed
		//System.out.println(requestContext.getUriInfo().getPath());
		
		List<String> authHeaders =  requestContext.getHeaders().get("Authorization");
		if(authHeaders != null) {
			String authorizedData = authHeaders.get(0); // Basic YWxleDoxMjM0NQ==
			String splitData = authorizedData.split(" ")[1]; //["Basic", "YWxleDoxMjM0NQ=="]
			//decode the value using Base64 of java.util package
			byte[] decodedBytes = Base64.getDecoder().decode(splitData);
			String decodedString = new String(decodedBytes);//username:password
			String[] splitDecoded = decodedString.split(":");//["username", "password"]
			String username = splitDecoded[0];
			String password = splitDecoded[1];
			if(username.equals("alex") && password.equals("alex@123")) {
				return;
			}
		}
		
		Response response = Response.status(401).entity("Access Denied").build();
		requestContext.abortWith(response);
	}

}
