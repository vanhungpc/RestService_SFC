package com.dvhung.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/services")
public class ServiceResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello, restfull web service";
	}
}
