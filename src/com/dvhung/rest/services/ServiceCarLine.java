package com.dvhung.rest.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.dvhung.rest.services.dao.CarLineDAO;
import com.dvhung.rest.services.pojo.CarLine;

@Path("/carline")
public class ServiceCarLine {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CarLine> getAll() throws SQLException {
		return CarLineDAO.GetAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public CarLine get(@PathParam("id") String id)
			throws NumberFormatException, SQLException {
		return CarLineDAO.Get(Integer.parseInt(id));
	}

	// insert Caline
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(CarLine cl) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// update Caline

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(CarLine cl) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete Carline

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(CarLine cl) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
}
