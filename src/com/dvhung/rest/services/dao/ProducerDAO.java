package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Producer;

public class ProducerDAO {
	public static String TABLE_NAME = "dbo_producer";
	public static String ID = "ID_Pro";
	public static String NAME = "Name_Producer";

	// get all carline
	public static List<Producer> GetAll() throws SQLException {
		List<Producer> producer = new ArrayList<Producer>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				Producer pro = new Producer();
				pro.setIdPro(rs.getInt(ID));
				pro.setNameProducer(rs.getString(NAME));
				producer.add(pro);
			}
			statement.close();
			con.close();
		}

		return producer;
	}

	// get Carline by id
	public static Producer Get(int id) throws SQLException {
		Producer pro = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				pro = new Producer();
				pro.setIdPro(rs.getInt(ID));
				pro.setNameProducer(rs.getString(NAME));
			}

			con.close();
		}
		return pro;
	}

	// insert Account
	public static boolean Add(Producer pro) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + NAME + ")";

		insertTableSQL += "VALUES(?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, pro.getNameProducer());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update Account
	public static boolean Update(Producer pro) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + NAME
				+ " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, pro.getNameProducer());
			preparedStatement.setInt(2, pro.getIdPro());

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