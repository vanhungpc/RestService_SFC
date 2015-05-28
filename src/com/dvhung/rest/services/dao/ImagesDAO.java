package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Images;

public class ImagesDAO {

	private static String TABLE_NAME = "dbo_images";
	private static String ID = "ID_Img";
	private static String ID_CAR = "ID_Car";
	private static String NAME = "Name";
	private static String URL = "URL";

	// get all images
	public static List<Images> GetAll() throws SQLException {
		List<Images> images = new ArrayList<Images>();

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);

			while (rs.next()) {
				Images a = new Images();
				a.setIdImg(rs.getInt(ID));
				a.setIdCar(rs.getInt(ID_CAR));
				a.setName(rs.getString(NAME));
				a.setUrl(rs.getString(URL));
				images.add(a);
			}

			statement.close();
			con.close();
		}

		return images;
	}

	public static Images GetImageById(int id) throws SQLException {
		Images img = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				img = new Images();
				img.setIdImg(rs.getInt(ID));
				img.setIdCar(rs.getInt(ID_CAR));
				img.setName(rs.getString(NAME));
				img.setUrl(rs.getString(URL));
			}
		}
		return img;
	}

	// get account by id
	public static Images Get(int id) throws SQLException {
		Images image = null;

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				image = new Images();
				image.setIdImg(rs.getInt(ID));
				image.setIdCar(rs.getInt(ID_CAR));
				image.setName(rs.getString(NAME));
				image.setUrl(rs.getString(URL));
			}

			con.close();
		}

		return image;
	}

	// get list images by idcar
	public static List<Images> GetArrayImageByIdCar(int id) throws SQLException {
		List<Images> arrImg = new ArrayList<Images>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID_CAR + "=" + id);
			while (rs.next()) {
				Images img = new Images();
				img.setIdImg(rs.getInt(ID));
				img.setIdCar(rs.getInt(ID_CAR));
				img.setName(rs.getString(NAME));
				img.setUrl(rs.getString(URL));
				arrImg.add(img);
			}
			rs.close();
			con.close();
		}
		return arrImg;
	}

	// get comment by idVehicle
	public static List<Images> GetByIdCar(int idCar) throws SQLException {
		List<Images> images = new ArrayList<Images>();

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID_CAR + "=" + idCar);
			while (rs.next()) {
				Images img = new Images();
				img.setIdCar(rs.getInt(ID));
				img.setIdCar(rs.getInt(ID_CAR));
				img.setName(rs.getString(NAME));
				img.setUrl(rs.getString(URL));
				images.add(img);
			}
			rs.close();

			con.close();
		}

		return images;
	}

	// insert images
	public static boolean Add(Images img) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + ID_CAR
				+ ", " + NAME + ", " + URL + ")";
		insertTableSQL += " VALUES(?, ?, ?)";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, img.getIdCar());
			preparedStatement.setString(2, img.getName());
			preparedStatement.setString(3, img.getUrl());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// update images
	public static boolean Update(Images img) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + ID_CAR
				+ " = ?, " + NAME + " = ?, " + URL + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, img.getIdCar());
			preparedStatement.setString(2, img.getName());
			preparedStatement.setString(3, img.getUrl());
			preparedStatement.setInt(4, img.getIdImg());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// delete images
	public static boolean Delete(int id) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "DELETE FROM " + TABLE_NAME;
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, id);

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}
}
