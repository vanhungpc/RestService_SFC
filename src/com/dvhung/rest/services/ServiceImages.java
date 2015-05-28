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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dvhung.rest.services.dao.AccountDAO;
import com.dvhung.rest.services.dao.ImagesDAO;
import com.dvhung.rest.services.pojo.Account;
import com.dvhung.rest.services.pojo.Images;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/images")
public class ServiceImages {
	// get all images
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Images> getAll() throws SQLException {
		return ImagesDAO.GetAll();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response imageUpload(
			@FormDataParam("image") InputStream hereIsImage,
			@FormDataParam("image") FormDataContentDisposition hereIsName,
			@Context HttpServletRequest request) {
		// String path = System.getenv("HOME")+"/tmp/";
		// String path = "/usr/local/tomcat7/images/";
		// String path = getDomainName(request) +
		// "/RestService_SFC/resources/images/";

		// Client client = Client.create();
		// WebResource getWebResource =
		// client.resource("http://192.168.0.109:8888/RestService_SFC/resources/images/");
		// String path =
		// "D://apache-tomcat-7.0.52/webapps/upload/resources/uploads/";
		String path = "/usr/local/tomcat7/webapps/upload/resources/uploads/";
		if (hereIsName.getSize() == 0) {
			return Response.status(500).entity("image parameter is missing")
					.build();
		}
		String name = hereIsName.getFileName();
		path += name;
		String output = "http://49.212.156.64:8080/upload/resources/uploads/";
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

	@SuppressWarnings("unused")
	private String getDomainName(HttpServletRequest request) {
		return request.getProtocol().toLowerCase().replaceAll("[0-9./]", "")
				+ "://" + request.getServerName() + ":"
				+ request.getServerPort();
	}

	// private String getRelativePath() {
	// String fileSeparator = "/";
	// DateUtil dateUtil = new DateUtil();
	// int[] yearMonthDay = dateUtil.getDayMonthYear();
	// return "/resources/uploads/" + yearMonthDay[0] + fileSeparator
	// + yearMonthDay[1] + fileSeparator + yearMonthDay[2];
	// }

	// insert detail car

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Images img) throws SQLException {
		ImagesDAO.Add(img);
		// int id = DetailCarDAO.getIdLastIndex();
		return Response.status(200).entity("OK").build();
	}

	// update detail car

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Images img) throws SQLException {
		ImagesDAO.Update(img);
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

	// delete detail car
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(Images img) throws SQLException {
		ImagesDAO.Delete(img.getIdImg());
		String out = "OK";
		return Response.status(200).entity(out).build();
	}

}
