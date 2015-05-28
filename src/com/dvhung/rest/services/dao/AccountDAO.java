package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Account;

public class AccountDAO {
	public static String TABLE_NAME = "dbo_account";
	public static String ID = "ID_Acc";
	public static String USER_NAME = "Name";
	public static String PASSWORD = "Password";
	public static String EMAIL = "Email";
	public static String PHONE_NUMBER = "PhoneNumber";
	public static String BIRTH_DAY = "BirtDay";
	public static String ADDRESS = "Address";
	public static String AVATAR = "Avartar";

	// get all Account
	public static List<Account> GetAll() throws SQLException {
		List<Account> accounts = new ArrayList<Account>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				Account acc = new Account();
				acc.setIdAcc(rs.getInt(ID));
				acc.setName(rs.getString(USER_NAME));
				acc.setPassword(rs.getString(PASSWORD));
				acc.setEmail(rs.getString(EMAIL));
				acc.setBirthDay(rs.getString(BIRTH_DAY));
				acc.setAddress(rs.getString(ADDRESS));
				acc.setPhoneNumber(rs.getInt(PHONE_NUMBER));
				acc.setAvatar(rs.getString(AVATAR));
				accounts.add(acc);
			}
			statement.close();
			con.close();
		}

		return accounts;
	}

	// get Account by id
	public static Account Get(int id) throws SQLException {
		Account accounts = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				accounts = new Account();
				accounts.setIdAcc(rs.getInt(ID));
				accounts.setName(rs.getString(USER_NAME));
				accounts.setPassword(rs.getString(PASSWORD));
				accounts.setEmail(rs.getString(EMAIL));
				accounts.setBirthDay(rs.getString(BIRTH_DAY));
				accounts.setAddress(rs.getString(ADDRESS));
				accounts.setPhoneNumber(rs.getInt(PHONE_NUMBER));
				accounts.setAvatar(rs.getString(AVATAR));
			}
			statement.close();
			con.close();
		}
		return accounts;
	}

	// insert Account
	public static boolean Add(Account a) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + USER_NAME
				+ ", " + PASSWORD + ", " + BIRTH_DAY + ", " + ADDRESS + ", "
				+ PHONE_NUMBER + ", " + EMAIL + ", " + AVATAR + ")";

		insertTableSQL += "VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, a.getName());
			preparedStatement.setString(2, a.getPassword());
			preparedStatement.setString(3, a.getBirthDay());
			preparedStatement.setString(4, a.getAddress());
			preparedStatement.setInt(5, a.getPhoneNumber());
			preparedStatement.setString(6, a.getEmail());
			preparedStatement.setString(7, a.getAvatar());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update Account
	public static boolean Update(Account a) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + " SET " + USER_NAME
				+ " = ?, " + PASSWORD + " = ?, " + BIRTH_DAY + " = ?, " + ADDRESS
				+ " = ?, " + PHONE_NUMBER + " = ?, " + EMAIL + " = ?, " + AVATAR + " = ?";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, a.getName());
			preparedStatement.setString(2, a.getPassword());
			preparedStatement.setString(3, a.getBirthDay());
			preparedStatement.setString(4, a.getAddress());
			preparedStatement.setInt(5, a.getPhoneNumber());
			preparedStatement.setString(6, a.getEmail());
			preparedStatement.setString(7, a.getAvatar());
			preparedStatement.setInt(8, a.getIdAcc());
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
	
	//check user name and password
	public static int checkLogin(String userName, String password) throws SQLException{
		int idAcc = 0;
		
		Connection con = DatabaseHelper.TalkDatabase();
		if(con != null){
			String sql = "SELECT * FROM " + TABLE_NAME + " WHERE Name = '" +  userName +"' AND Password  = '" + password +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				idAcc = rs.getInt(ID);
				break;
			}
			statement.close();
		}
		con.close();
		return idAcc;
	}
	
	//check account exits
		public static boolean checkUserName(String userName) throws SQLException{
			boolean flag = false;
			
			Connection con = DatabaseHelper.TalkDatabase();
			if(con != null){
				String sql = "SELECT * FROM " + TABLE_NAME + " WHERE Name = '" +  userName+"'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()){
					flag = true;
					break;
				}
				statement.close();
			}
			con.close();
			return flag;
		}
	
}
