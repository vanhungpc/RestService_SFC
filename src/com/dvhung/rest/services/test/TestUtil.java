package com.dvhung.rest.services.test;

import java.sql.SQLException;
import java.util.List;

import com.dvhung.rest.services.dao.AccountDAO;
import com.dvhung.rest.services.dao.CarDAO;
import com.dvhung.rest.services.dao.DetailCarDAO;
import com.dvhung.rest.services.helper.DatabaseHelper;
import com.dvhung.rest.services.pojo.Account;
import com.dvhung.rest.services.pojo.Car;
import com.dvhung.rest.services.pojo.DetailCar;

public class TestUtil {
	public static void main(String args[]) throws SQLException{
//		DatabaseHelper.TalkDatabase();
//		Account a = AccountDAO.Get(2);
//		System.out.println("User Name " + a.getName());
		
//		Account a = new Account();
//		//a.setIdAcc(3);
//		a.setName("toanh");
//		a.setPassword("123456");
//		a.setBirthDay("22/05/2014");
//		a.setAddress("tran trong cung");
//		a.setEmail("toanh@gmail.com");
//		a.setPhoneNumber(12345678);
//		
//		boolean flag = AccountDAO.Add(a);
//		if(flag){
//			System.out.println("OK");
//		}else
//			System.out.println("Not OK");
//		
		
		
//		
//		boolean flag = AccountDAO.Delete(3);
//		if(flag){
//			System.out.println("OK");
//		}else
//			System.out.println("Not OK");
//		
		
//		DetailCar dto = new DetailCar();
//		dto.setNameDetail("hung");
//		dto.setPrice(16);
//		dto.setGrear("abc");
//		dto.setTransType("abc");
//		dto.setOrigin("ABC");
//		dto.setFuel("abc");
//		dto.setIntProduction(12);
//		dto.setNumberKM(12);
//		dto.setColorCar("read");
//		dto.setColorInterior("white");
//		dto.setDecription("abc");
//		boolean flag = DetailCarDAO.Add(dto);
//		int serverResponseCode = -1;
//		String upLoadServerUri = "http://192.168.0.102:8888/dwe/index.php/events/uploadImage";
		
		
//		Account acc = new Account();
//		acc.setName("binhhva");
//		acc.setPassword("123456");
//		int flag = AccountDAO.checkLogin(acc.getName(), acc.getPassword());
//		System.out.println(flag);
//		int i = flag;
		
//		Car car = new Car();
//		car.setNameCar("xe hoi");
//		car.setTimeSale("12");
//		car.setIdCarline(1);
//		car.setIdModel(2);
//		car.setIdAcc(1);
//		car.setIdDetal(1);
//		car.setIdCity(1);
//		car.setLat("21");
//		car.setLon("32");
//		boolean add = CarDAO.AddCar(car);
//		System.out.println(add);
		List<Car> lst = CarDAO.GetAllCar();
		List<Car> t = lst;
		
		
	}
}
