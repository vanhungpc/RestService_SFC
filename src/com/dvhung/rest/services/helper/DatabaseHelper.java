package com.dvhung.rest.services.helper;

import java.sql.*;
import javax.swing.*;

public class DatabaseHelper {

//	public static String strURL = "jdbc:sqlserver://localhost:1433;databaseName=SEARCH_FOR_CAR;user=sa;password=123456a@";
	public static String strURL = "jdbc:mysql://49.212.156.64/SEARCH_FOR_CAR?"
            + "user=vanhungpc&password=12345678";
	public static Connection TalkDatabase() {
		Connection con = null;
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection(strURL);
			System.out
					.println("Connect database seach_for_car OKKKKKKKKKK....");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}

		return con;
	}

	@SuppressWarnings("null")
	public static void InterupConnection(Connection con) {
		try {
			if (con != null || con.isClosed() != true)
				con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static ResultSet myExcuteQuery(Connection cnn, String sql) {
		ResultSet rs = null;

		try {
			Statement st = cnn.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}

		return rs;
	}

	public static boolean myExcuteUpdate(PreparedStatement pr) {
		boolean flag = false;
		try {
			int row = pr.executeUpdate();
			flag = row != 0 ? true : false;
			pr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}

		return flag;
	}

	public static void myExcuteUpdate(Connection cnn, String sql) {
		try {
			Statement st = cnn.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
}
