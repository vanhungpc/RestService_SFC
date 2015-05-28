package com.dvhung.rest.services;

import java.sql.SQLException;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvhung.rest.services.dao.CityDAO;
import com.dvhung.rest.services.pojo.City;

@Path("/city")
public class ServiceCity {
	// get all city
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getAll() throws SQLException {
		return CityDAO.GetAll();
	}

	// get city by id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public City get(@PathParam("id") String id) throws NumberFormatException,
			SQLException {
		return CityDAO.Get(Integer.parseInt(id));
	}

	// insert city
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(City ct) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
	
	//update city
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(City ct){
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
	
	//delete city
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(City ct){
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
}
