package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Location;

public class LocationDAO {

	public static String TABLE_NAME = "dbo_location";
	public static String ID = "ID_Local";
	public static String LAT = "Lat";
	public static String LON = "Lon";
	public static String FLAG = "Flag_Local";

	// get all carline
	public static List<Location> GetAllLocation() throws SQLException {
		List<Location> local = new ArrayList<Location>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				Location l = new Location();
				l.setIdLocal(rs.getInt(ID));
				l.setLat(rs.getFloat(LAT));
				l.setLon(rs.getFloat(LON));
				l.setFlagLocal(rs.getInt(FLAG));
				local.add(l);
			}
			statement.close();
			con.close();
		}

		return local;
	}

	// get Carline by id
	public static Location Get(int id) throws SQLException {
		Location l = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				l = new Location();
				l.setIdLocal(rs.getInt(ID));
				l.setLat(rs.getFloat(LAT));
				l.setLon(rs.getFloat(LON));
				l.setFlagLocal(rs.getInt(FLAG));
			}

			con.close();
		}
		return l;
	}

	// insert Account
	public static boolean Add(Location l) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + LAT + ", "
				+ LON + ", " + FLAG + ")";

		insertTableSQL += "VALUES(?, ?, ?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setFloat(1, l.getLat());
			preparedStatement.setFloat(2, l.getLon());
			preparedStatement.setInt(3, l.getFlagLocal());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update Account
	public static boolean Update(Location l) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + LAT
				+ " = ?, " + LON + " = ?, " + FLAG + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setFloat(1, l.getLat());
			preparedStatement.setFloat(2, l.getLon());
			preparedStatement.setInt(3, l.getFlagLocal());
			preparedStatement.setInt(4, l.getIdLocal());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// Delete Account
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