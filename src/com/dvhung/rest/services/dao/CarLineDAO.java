package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.CarLine;

public class CarLineDAO {

	public static String TABLE_NAME = "dbo_carline";
	public static String ID = "ID_Carline";
	public static String NAME = "Name_CarLine";

	// get all carline
	public static List<CarLine> GetAll() throws SQLException {
		List<CarLine> carline = new ArrayList<CarLine>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				CarLine carl = new CarLine();
				carl.setIdCarline(rs.getInt(ID));
				carl.setNameCarline(rs.getString(NAME));
				carline.add(carl);
			}
			statement.close();
			con.close();
		}

		return carline;
	}

	// get Carline by id
	public static CarLine Get(int id) throws SQLException {
		CarLine carline = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				carline = new CarLine();
				carline.setIdCarline(rs.getInt(ID));
				carline.setNameCarline(rs.getString(NAME));
			}

			con.close();
		}
		return carline;
	}

	// insert Account
	public static boolean Add(CarLine a) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + NAME + ")";

		insertTableSQL += "VALUES(?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, a.getNameCarline());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update Account
	public static boolean Update(CarLine a) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + NAME
				+ " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, a.getNameCarline());
			preparedStatement.setInt(2, a.getIdCarline());

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
