package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Model;

public class ModelDAO {

	private static String TABLE_NAME = "dbo_model";
	private static String ID = "ID_Mo";
	private static String ID_RO = "ID_Pro";
	private static String NAME = "Name_Model";

	// get all account
	public static List<Model> GetAll() throws SQLException {
		List<Model> model = new ArrayList<Model>();

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);

			while (rs.next()) {
				Model m = new Model();
				m.setIdMo(rs.getInt(ID));
				m.setIdPro(rs.getInt(ID_RO));
				m.setNameModel(rs.getString(NAME));
				model.add(m);
			}

			statement.close();
			con.close();
		}

		return model;
	}

	// get account by id
	public static Model Get(int id) throws SQLException {
		Model model = null;

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				model = new Model();
				model.setIdMo(rs.getInt(ID));
				model.setIdPro(rs.getInt(ID_RO));
				model.setNameModel(rs.getString(NAME));
			}

			con.close();
		}

		return model;
	}

	// insert account
	public static boolean Add(Model model) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + ID_RO
				+ ", " + NAME + ")";
		insertTableSQL += " VALUES(?, ?)";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, model.getIdPro());
			preparedStatement.setString(2, model.getNameModel());

			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// update account
	public static boolean Update(Model model) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + ID_RO
				+ " = ?, " + NAME + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, model.getIdPro());
			preparedStatement.setString(2, model.getNameModel());
			preparedStatement.setInt(3, model.getIdMo());

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
