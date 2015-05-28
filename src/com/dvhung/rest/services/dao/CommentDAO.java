package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Comment;

public class CommentDAO {
	private static String TABLE_NAME = "dbo_comment";
	private static String ID = "ID_Com";
	private static String ID_CAR = "ID_Car";
	private static String ID_ACC = "ID_Acc";
	private static String COMMENT = "Content_Comment";
	private static String USERNAME = "UserName";

	// get all account
	public static List<Comment> GetAll() throws SQLException {
		List<Comment> comments = new ArrayList<Comment>();

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);

			while (rs.next()) {
				Comment c = new Comment();
				c.setIdCom(rs.getInt(ID));
				c.setIdCar(rs.getInt(ID_CAR));
				c.setIdAcc(rs.getInt(ID_ACC));
				c.setContentComment(rs.getString(COMMENT));
				c.setUserName(rs.getString(USERNAME));
				comments.add(c);
			}

			statement.close();
			con.close();
		}

		return comments;
	}

	// get account by id
	public static Comment Get(int id) throws SQLException {
		Comment comment = null;

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				comment = new Comment();
				comment.setIdCom(rs.getInt(ID));
				comment.setIdCar(rs.getInt(ID_CAR));
				comment.setIdAcc(rs.getInt(ID_ACC));
				comment.setContentComment(rs.getString(COMMENT));
				comment.setUserName(rs.getString(USERNAME));
			}

			con.close();
		}

		return comment;
	}

	// get comment by idVehicle
	public static List<Comment> GetByIdCar(int idCar) throws SQLException {
		List<Comment> comments = new ArrayList<Comment>();

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID_CAR + "=" + idCar);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIdCom(rs.getInt(ID));
				comment.setIdCar(rs.getInt(ID_CAR));
				comment.setIdAcc(rs.getInt(ID_ACC));
				comment.setContentComment(rs.getString(COMMENT));
				comment.setUserName(rs.getString(USERNAME));
				comments.add(comment);
			}

			con.close();
		}

		return comments;
	}

	// get all comment by account and car
	public static List<Comment> getCommentByIdCarAndIdAcc(int idCar, int idAcc)
			throws SQLException {
		List<Comment> comments = new ArrayList<Comment>();

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID_CAR + "=" + idCar + " AND " + ID_ACC
					+ " =" + idAcc + " ORDER BY ID_Com DESC");
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIdCom(rs.getInt(ID));
				comment.setIdCar(rs.getInt(ID_CAR));
				comment.setIdAcc(rs.getInt(ID_ACC));
				comment.setContentComment(rs.getString(COMMENT));
				comment.setUserName(rs.getString(USERNAME));
				comments.add(comment);
			}

			con.close();
		}

		return comments;
	}

	// insert account
	public static boolean Add(Comment com) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + ID_CAR
				+ ", " + ID_ACC + ", " + COMMENT + ", " + USERNAME +")";
		insertTableSQL += " VALUES(?, ?, ?, ?)";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, com.getIdCar());
			preparedStatement.setInt(2, com.getIdAcc());
			preparedStatement.setString(3, com.getContentComment());
			preparedStatement.setString(4, com.getUserName());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}

		return flag;
	}

	// update account
	public static boolean Update(Comment a) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + ID_CAR
				+ " = ?, " + COMMENT + " = ?, " + USERNAME + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();

		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, a.getIdCar());
			preparedStatement.setString(2, a.getContentComment());
			preparedStatement.setString(3, a.getUserName());
			preparedStatement.setInt(4, a.getIdCom());
			
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