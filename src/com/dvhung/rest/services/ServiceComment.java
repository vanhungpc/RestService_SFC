package com.dvhung.rest.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvhung.rest.services.dao.CommentDAO;
import com.dvhung.rest.services.pojo.Comment;

@Path("/comment")
public class ServiceComment {
	// get all comment
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAll() throws SQLException {
		return CommentDAO.GetAll();
	}

	// get comment by id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Comment get(String id) throws NumberFormatException, SQLException {
		return CommentDAO.Get(Integer.parseInt(id));
	}

	// insert comment
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Comment cm) throws SQLException {
		String out = "OK";
		CommentDAO.Add(cm);
		return Response.status(200).entity(out).build();
	}

	// update comment
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Comment cm) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete comment
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(Comment cm) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}
}
