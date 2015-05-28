package com.dvhung.rest.services;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvhung.rest.services.dao.DetailCarDAO;
import com.dvhung.rest.services.pojo.DetailCar;

@Path("/detailcar")
public class ServiceDetailCar {
	// get all detail car

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DetailCar> getAll() throws SQLException {
		return DetailCarDAO.GetAll();
	}

	// get detail car by id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public DetailCar get(String id) throws NumberFormatException, SQLException {
		return DetailCarDAO.Get(Integer.parseInt(id));
	}

	// insert detail car

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(DetailCar dc) throws SQLException {
		DetailCarDAO.Add(dc);
		int id = DetailCarDAO.getIdLastIndex();
		return Response.status(200).entity(String.valueOf(id)).build();
	}

	// update detail car

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(DetailCar dc) throws SQLException {
		DetailCarDAO.Update(dc);
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete detail car
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(DetailCar dc) throws SQLException {
		DetailCarDAO.Delete(dc.getIdDetail());
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
}
