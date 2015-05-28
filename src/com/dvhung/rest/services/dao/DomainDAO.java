package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Domain;

public class DomainDAO {

	public static String TABLE_NAME = "dbo_domain";
	public static String ID = "ID_Do";
	public static String NAME = "Name_Domain";

	// get all carline
	public static List<Domain> GetAll() throws SQLException {
		List<Domain> domain = new ArrayList<Domain>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				Domain dom = new Domain();
				dom.setIdDo(rs.getInt(ID));
				dom.setNameDomain(rs.getString(NAME));
				domain.add(dom);
			}
			statement.close();
			con.close();
		}

		return domain;
	}

	// get Carline by id
	public static Domain Get(int id) throws SQLException {
		Domain dom = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				dom = new Domain();
				dom.setIdDo(rs.getInt(ID));
				dom.setNameDomain(rs.getString(NAME));
			}

			con.close();
		}
		return dom;
	}

	// insert Account
	public static boolean Add(Domain a) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + NAME + ")";

		insertTableSQL += "VALUES(?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, a.getNameDomain());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update Account
	public static boolean Update(Domain a) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + NAME
				+ " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, a.getNameDomain());
			preparedStatement.setInt(2, a.getIdDo());

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
