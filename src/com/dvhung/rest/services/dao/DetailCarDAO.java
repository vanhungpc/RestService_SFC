package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.DetailCar;

public class DetailCarDAO {
	public static String TABLE_NAME = "dbo_detailcar";
	public static String ID = "ID_Detail";
	public static String NAME = "Name_Detail";
	public static String PRICE = "Price";
	public static String BODY_TYPE = "Body_Type";
	public static String DOORS = "Doors";
	public static String EXTERIOR_COLOR = "Exterior_Color";
	public static String FUEL = "Fuel";
	public static String ENGINE = "Engine";
	public static String TRANSMISSION = "Transmission";
	public static String ORIGIN = "Origin";
	public static String MILLIAGE = "Milliage";

	// get all car
	public static List<DetailCar> GetAll() throws SQLException {
		List<DetailCar> detailcar = new ArrayList<DetailCar>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				DetailCar detail = new DetailCar();
				detail.setIdDetail(rs.getInt(ID));
				detail.setNameDetail(rs.getString(NAME));
				detail.setPrice(rs.getString(PRICE));
				detail.setBodyType(BODY_TYPE);
				detail.setDoors(DOORS);
				detail.setExteriorColor(EXTERIOR_COLOR);
				detail.setFuel(FUEL);
				detail.setEngine(ENGINE);
				detail.setTransmission(TRANSMISSION);
				detail.setOrigin(ORIGIN);
				detail.setMilliage(MILLIAGE);
				detailcar.add(detail);
			}
			statement.close();
			con.close();
		}
		return detailcar;
	}

	// get car buy id
	public static DetailCar Get(int id) throws SQLException {
		DetailCar detail = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				detail = new DetailCar();
				detail.setIdDetail(rs.getInt(ID));
				detail.setNameDetail(rs.getString(NAME));
				detail.setPrice(rs.getString(PRICE));
				detail.setBodyType(BODY_TYPE);
				detail.setDoors(DOORS);
				detail.setExteriorColor(EXTERIOR_COLOR);
				detail.setFuel(FUEL);
				detail.setEngine(ENGINE);
				detail.setTransmission(TRANSMISSION);
				detail.setOrigin(ORIGIN);
				detail.setMilliage(MILLIAGE);

			}
			statement.close();
			con.close();
		}
		return detail;
	}

	public static int getIdLastIndex() throws SQLException {
		int id = 0;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " ORDER BY " + ID + " DESC");
			while (rs.next()) {
				id = rs.getInt(ID);
				break;
			}
			statement.close();
			con.close();
		}

		return id;
	}

	// insert car
	public static boolean Add(DetailCar detail) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + NAME + ", "
				+ PRICE + ", " + BODY_TYPE + ", " + DOORS + ", "
				+ EXTERIOR_COLOR + ", " + FUEL + ", " + ENGINE + ", "
				+ TRANSMISSION + ", " + ORIGIN + ", " + MILLIAGE + ")";

		insertTableSQL += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, detail.getNameDetail());
			preparedStatement.setString(2, detail.getPrice());
			preparedStatement.setString(3, detail.getBodyType());
			preparedStatement.setString(4, detail.getDoors());
			preparedStatement.setString(5, detail.getExteriorColor());
			preparedStatement.setString(6, detail.getFuel());
			preparedStatement.setString(7, detail.getEngine());
			preparedStatement.setString(8, detail.getTransmission());
			preparedStatement.setString(9, detail.getOrigin());
			preparedStatement.setString(10, detail.getMilliage());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);

			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update car
	public static boolean Update(DetailCar detail) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + "(" + NAME + ", "
				+ PRICE + ", " + BODY_TYPE + ", " + DOORS + ", "
				+ EXTERIOR_COLOR + ", " + FUEL + ", " + ENGINE + ", "
				+ TRANSMISSION + ", " + ORIGIN + ", " + MILLIAGE + ")";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, detail.getNameDetail());
			preparedStatement.setString(2, detail.getPrice());
			preparedStatement.setString(3, detail.getBodyType());
			preparedStatement.setString(4, detail.getDoors());
			preparedStatement.setString(5, detail.getExteriorColor());
			preparedStatement.setString(6, detail.getFuel());
			preparedStatement.setString(7, detail.getEngine());
			preparedStatement.setString(8, detail.getTransmission());
			preparedStatement.setString(9, detail.getOrigin());
			preparedStatement.setString(10, detail.getMilliage());
			preparedStatement.setInt(11, detail.getIdDetail());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// delete car

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
