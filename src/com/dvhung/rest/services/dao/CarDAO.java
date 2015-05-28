package com.dvhung.rest.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Car;

public class CarDAO {

	public static String TABLE_NAME = "dbo_car";
	public static String ID = "ID_Car";
	public static String NAME_CAR = "Name_Car";
	public static String TIME_SALE = "Time_Sale";
	public static String ID_CAR_LINE = "ID_Carline";
	public static String ID_MODEL = "ID_Model";
	public static String ID_ACC = "ID_Acc";
	public static String ID_DETAIL = "ID_Detail";
	public static String ID_CITY = "ID_City";
	public static String LAT = "lat";
	public static String LON = "lon";

	// get all car
	public static List<Car> GetAllCar() throws SQLException {
		List<Car> car = new ArrayList<Car>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY ID_Car DESC");
			while (rs.next()) {
				Car c = new Car();
				c.setIdCar(rs.getInt(ID));
				c.setNameCar(rs.getString(NAME_CAR));
				c.setTimeSale(rs.getString(TIME_SALE));
				c.setIdCarline(rs.getInt(ID_CAR_LINE));
				c.setIdModel(rs.getInt(ID_MODEL));
				c.setIdAcc(rs.getInt(ID_ACC));
				c.setIdDetal(rs.getInt(ID_DETAIL));
				c.setIdCity(rs.getInt(ID_CITY));
				// c.setCarline(CarLineDAO.Get(c.getIdCarline()));
				// c.setModel(ModelDAO.Get(c.getIdModel()));
				// c.setAccount(AccountDAO.Get(c.getIdAcc()));
				c.setDetailCar(DetailCarDAO.Get(c.getIdDetal()));
				// c.setCity(CityDAO.Get(c.getIdCity()));
				// c.setComment(CommentDAO.GetByIdCar(c.getIdCar()));
				// c.setImages(ImagesDAO.GetByIdCar(c.getIdCar()));
				// c.setProducer(ProducerDAO.Get(c.getIdModel()));
				// c.setDomain(DomainDAO.Get(c.getIdCity()));
				c.setArrImage(ImagesDAO.GetArrayImageByIdCar(rs.getInt(ID)));
				c.setArrComment(CommentDAO.getCommentByIdCarAndIdAcc(
						rs.getInt(ID), rs.getInt(ID_ACC)));
				c.setLat(rs.getString(LAT));
				c.setLon(rs.getString(LON));
				car.add(c);
			}
			statement.close();
			con.close();
		}
		return car;
	}

	// get all car by idAcc
	public static List<Car> GetAllCarByIdAcc(int idAcc) throws SQLException {
		List<Car> car = new ArrayList<Car>();
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE ID_ACC = " + idAcc);
			while (rs.next()) {
				Car c = new Car();
				c.setIdCar(rs.getInt(ID));
				c.setNameCar(rs.getString(NAME_CAR));
				c.setTimeSale(rs.getString(TIME_SALE));
				c.setIdCarline(rs.getInt(ID_CAR_LINE));
				c.setIdModel(rs.getInt(ID_MODEL));
				c.setIdAcc(rs.getInt(ID_ACC));
				c.setIdDetal(rs.getInt(ID_DETAIL));
				c.setIdCity(rs.getInt(ID_CITY));
				// c.setCarline(CarLineDAO.Get(c.getIdCarline()));
				// c.setModel(ModelDAO.Get(c.getIdModel()));
				// c.setAccount(AccountDAO.Get(c.getIdAcc()));
				c.setDetailCar(DetailCarDAO.Get(c.getIdDetal()));
				// c.setCity(CityDAO.Get(c.getIdCity()));
				// c.setComment(CommentDAO.GetByIdCar(c.getIdCar()));
				// c.setImages(ImagesDAO.GetByIdCar(c.getIdCar()));
				// c.setProducer(ProducerDAO.Get(c.getIdModel()));
				// c.setDomain(DomainDAO.Get(c.getIdCity()));
				c.setArrImage(ImagesDAO.GetArrayImageByIdCar(rs.getInt(ID)));
				c.setArrComment(CommentDAO.getCommentByIdCarAndIdAcc(
						rs.getInt(ID), rs.getInt(ID_ACC)));
				c.setLat(rs.getString(LAT));
				c.setLon(rs.getString(LON));
				car.add(c);
			}
			statement.close();
			con.close();
		}
		return car;
	}

	// get car buy id
	public static Car GetCarById(int id) throws SQLException {
		Car c = null;
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_NAME
					+ " WHERE " + ID + "=" + id);
			while (rs.next()) {
				c = new Car();
				c.setIdCar(rs.getInt(ID));
				c.setNameCar(rs.getString(NAME_CAR));
				c.setTimeSale(rs.getString(TIME_SALE));
				c.setIdCarline(rs.getInt(ID_CAR_LINE));
				c.setIdModel(rs.getInt(ID_MODEL));
				c.setIdAcc(rs.getInt(ID_ACC));
				c.setIdDetal(rs.getInt(ID_DETAIL));
				c.setIdCity(rs.getInt(ID_CITY));
				// c.setCarline(CarLineDAO.Get(c.getIdCarline()));
				// c.setModel(ModelDAO.Get(c.getIdModel()));
				// c.setAccount(AccountDAO.Get(c.getIdAcc()));
				c.setDetailCar(DetailCarDAO.Get(c.getIdDetal()));
				// c.setCity(CityDAO.Get(c.getIdCity()));
				// c.setComment(CommentDAO.GetByIdCar(c.getIdCar()));
				// c.setImages(ImagesDAO.GetByIdCar(c.getIdCar()));
				// c.setProducer(ProducerDAO.Get(c.getIdModel()));
				// c.setDomain(DomainDAO.Get(c.getIdCity()));
				c.setLat(rs.getString(LAT));
				c.setLon(rs.getString(LON));

			}
			statement.close();
			con.close();
		}
		return c;
	}

	// insert car
	public static boolean AddCar(Car c) throws SQLException {
		boolean flag = false;
		String insertTableSQL = "INSERT INTO " + TABLE_NAME + "(" + NAME_CAR
				+ ", " + TIME_SALE + ", " + ID_CAR_LINE + ", " + ID_MODEL
				+ ", " + ID_ACC + ", " + ID_DETAIL + ", " + ID_CITY + ", "
				+ LAT + ", " + LON + ")";

		insertTableSQL += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, c.getNameCar());
			preparedStatement.setString(2, c.getTimeSale());
			preparedStatement.setInt(3, c.getIdCarline());
			preparedStatement.setInt(4, c.getIdModel());
			preparedStatement.setInt(5, c.getIdAcc());
			preparedStatement.setInt(6, c.getIdDetal());
			preparedStatement.setInt(7, c.getIdCity());
			preparedStatement.setString(8, c.getLat());
			preparedStatement.setString(9, c.getLon());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// update car
	public static boolean UpdateCar(Car c) throws SQLException {
		boolean flag = false;
		String updateTableSQL = "UPDATE " + TABLE_NAME + "(" + NAME_CAR + ", "
				+ TIME_SALE + ", " + ID_CAR_LINE + ", " + ID_MODEL + ", "
				+ ID_ACC + ", " + ID_DETAIL + ", " + ID_CITY + ", " + LAT
				+ ", " + LON + ")";
		updateTableSQL += " WHERE " + ID + " = ?";

		Connection con = DatabaseHelper.TalkDatabase();
		if (con != null) {
			PreparedStatement preparedStatement = con
					.prepareStatement(updateTableSQL);
			preparedStatement.setString(1, c.getNameCar());
			preparedStatement.setString(2, c.getTimeSale());
			preparedStatement.setInt(3, c.getIdCarline());
			preparedStatement.setInt(4, c.getIdModel());
			preparedStatement.setInt(5, c.getIdAcc());
			preparedStatement.setInt(6, c.getIdDetal());
			preparedStatement.setInt(7, c.getIdCity());

			preparedStatement.setString(8, c.getLat());
			preparedStatement.setString(9, c.getLon());
			preparedStatement.setInt(10, c.getIdCar());
			flag = DatabaseHelper.myExcuteUpdate(preparedStatement);
			preparedStatement.close();
			con.close();
		}
		return flag;
	}

	// delete car

	public static boolean DeleteCar(int id) throws SQLException {
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

	// get id last index
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
}
