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

import com.dvhung.rest.services.dao.CarDAO;
import com.dvhung.rest.services.pojo.Car;

@Path("/addcar")
public class ServiceCar {
	// get all car
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAll() throws SQLException {
		return CarDAO.GetAllCar();
	}
	// get allCar by idAcc
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public List<Car> get(@PathParam("id") String id)
			throws NumberFormatException, SQLException {
		return CarDAO.GetAllCarByIdAcc(Integer.parseInt(id));
	}

	// get car by id
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{id}")
//	public Car get(@PathParam("id") String id) throws NumberFormatException,
//			SQLException {
//		return CarDAO.GetCarById(Integer.parseInt(id));
//	}



	// insert car
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Car c) throws SQLException {
		CarDAO.AddCar(c);
		int idCar = CarDAO.getIdLastIndex();
		return Response.status(200).entity(String.valueOf(idCar)).build();
	}

	// update car
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Car c) throws SQLException {
		CarDAO.UpdateCar(c);
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete car
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(Car c) throws SQLException {
		CarDAO.DeleteCar(c.getIdCar());
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
}
