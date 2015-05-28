package com.dvhung.rest.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvhung.rest.services.dao.AccountDAO;
import com.dvhung.rest.services.pojo.Account;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/accounts")
public class ServiceAccount {

//	//upload avartar
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response imageUpload(
			@FormDataParam("image") InputStream hereIsImage,
			@FormDataParam("image") FormDataContentDisposition hereIsName,
			@Context HttpServletRequest request) {
	
		String path = "/usr/local/tomcat7/webapps/upload/resources/uploads/avatar/";
		if (hereIsName.getSize() == 0) {
			return Response.status(500).entity("image parameter is missing")
					.build();
		}
		String name = hereIsName.getFileName();
		path += name;
		String output = "http://49.212.156.64:8080/upload/resources/uploads/avatar/";
		output += name;
		try {
			OutputStream out = new FileOutputStream(new File(path));
			int read;
			byte[] bytes = new byte[1024];
			while ((read = hereIsImage.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			return Response.status(500)
					.entity(path + " was not uploaded\n" + e.getMessage())
					.build();
		}
		return Response.status(200).entity(output).build();
	}
//	
	// get all account
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAll() throws SQLException {
		return AccountDAO.GetAll();
	}

	// get account by id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Account get(@PathParam("id") String id)
			throws NumberFormatException, SQLException {
		return AccountDAO.Get(Integer.parseInt(id));
	}
	//get all car by idAcc
	

	// insert account
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Account a) throws SQLException {
		boolean checkUserName = AccountDAO.checkUserName(a.getName());
		String out = "";
		if (!checkUserName) {
			AccountDAO.Add(a);
			out = "success";
		} else {
			out = "error";
		}

		return Response.status(200).entity(out).build();
	}

	// update account
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Account a) throws SQLException {
		AccountDAO.Update(a);
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete account
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(Account a) throws SQLException {
		AccountDAO.Delete(a.getIdAcc());
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create/query")
	public Response addQuery(@QueryParam("id") String id,
			@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("email") String email) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create/{id}/{username}/{password}/{email}")
	public Response addPathParam(@PathParam("id") String id,
			@PathParam("username") String username,
			@PathParam("password") String password,
			@PathParam("email") String email) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("create/form")
	public Response addUsingForm(@FormParam("id") String id,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("email") String email) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("put")
	public Response put(Account a) {
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/checklogin")
	public Response checkLogin(Account a) throws SQLException {
		int idAcc = AccountDAO.checkLogin(a.getName(), a.getPassword());
		return Response.status(200).entity(String.valueOf(idAcc)).build();
	}

}
