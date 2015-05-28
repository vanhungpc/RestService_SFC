package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.City;
public class CityDAO {

	private static String TABLE_NAME = "dbo_city";
	private static String ID = "ID_City";
	private static String ID_DO = "ID_Do";
	private static String NAME = "Name_City";

	// get all account
	public static List<City> GetAll() throws SQLException {
		List<City> city = new ArrayList<City>();

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);

			while (rs.next()) {
				City c = new City();
				c.setIdCity(rs.getInt(ID));
				c.setIdDo(rs.getInt(ID_DO));
				c.setNameCity(rs.getString(NAME));
				city.add(c);
			}

			statement.close();
			con.close();
		}

		return city;
	}

	// get account by id
	public static City Get(int id) throws SQLException {
		City city = null;

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				city = new City();
				city.setIdCity(rs.getInt(ID));
				city.setIdDo(rs.getInt(ID_DO));
				city.setNameCity(rs.getString(NAME));
			}

			con.close();
		}

		return city;
	}

	// insert account
	public static boolean Add(City city) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + ID_DO
				+ ", " + NAME + ")";
		insertTableSQL += " VALUES(?, ?)";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, city.getIdDo());
			preparedStatement.setString(2, city.getNameCity());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// update account
	public static boolean Update(City a) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + ID_DO
				+ " = ?, " + NAME + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, a.getIdDo());
			preparedStatement.setString(2, a.getNameCity());
			preparedStatement.setInt(3, a.getIdCity());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// delete account
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