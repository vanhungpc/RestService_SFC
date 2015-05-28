package com.dvhung.rest.services.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {

	private int idCar;
	private String nameCar;
	private String timeSale;
	private int idCarline;
	private int idModel;
	private int idAcc;
	private int idDetal;
	private int idCity;
//	private List<Images> images = new ArrayList<Images>();
//	private List<Comment> comment = new ArrayList<Comment>();
//	private Account account = new Account();
	private DetailCar detailCar;
//	private Model model = new Model();
//	private Location location = new Location();
//	private CarLine carline = new CarLine();
//	private City city = new City();
//
//	private Producer producer = new Producer();
//	private Domain domain = new Domain();
	private String lat;
	private String lon;
	private List<Images> arrImage;
	private List<Comment> arrComment;

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getNameCar() {
		return nameCar;
	}

	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
	}
//
//	public int getTimeSale() {
//		return timeSale;
//	}
//
//	public void setTimeSale(int timeSale) {
//		this.timeSale = timeSale;
//	}

	public int getIdCarline() {
		return idCarline;
	}

	public String getTimeSale() {
		return timeSale;
	}

	public void setTimeSale(String timeSale) {
		this.timeSale = timeSale;
	}

	public void setIdCarline(int idCarline) {
		this.idCarline = idCarline;
	}

	public int getIdModel() {
		return idModel;
	}

	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}


	public int getIdDetal() {
		return idDetal;
	}

	public void setIdDetal(int idDetal) {
		this.idDetal = idDetal;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

//	@XmlElement
//	public List<Images> getImages() {
//		return images;
//	}
//
//	@XmlElement
//	public void setImages(List<Images> images) {
//		this.images = images;
//	}
//
//	@XmlElement
//	public List<Comment> getComment() {
//		return comment;
//	}
//
//	@XmlElement
//	public void setComment(List<Comment> comment) {
//		this.comment = comment;
//	}
//
//	@XmlElement
//	public Account getAccount() {
//		return account;
//	}
//
//	@XmlElement
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//
//	@XmlElement
//	public DetailCar getDetailCar() {
//		return detailCar;
//	}
//
//	@XmlElement
//	public void setDetailCar(DetailCar detailCar) {
//		this.detailCar = detailCar;
//	}
//
//	@XmlElement
//	public Model getModel() {
//		return model;
//	}
//
//	@XmlElement
//	public void setModel(Model model) {
//		this.model = model;
//	}

//	@XmlElement
//	public Location getLocation() {
//		return location;
//	}
//
//	@XmlElement
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	@XmlElement
//	public CarLine getCarline() {
//		return carline;
//	}
//
//	@XmlElement
//	public void setCarline(CarLine carline) {
//		this.carline = carline;
//	}
//
//	@XmlElement
//	public City getCity() {
//		return city;
//	}
//
//	@XmlElement
//	public void setCity(City city) {
//		this.city = city;
//	}
//
//	public Producer getProducer() {
//		return producer;
//	}
//
//	public void setProducer(Producer producer) {
//		this.producer = producer;
//	}
//
//	public Domain getDomain() {
//		return domain;
//	}
//
//	public void setDomain(Domain domain) {
//		this.domain = domain;
//	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public DetailCar getDetailCar() {
		return detailCar;
	}

	public void setDetailCar(DetailCar detailCar) {
		this.detailCar = detailCar;
	}

	public List<Images> getArrImage() {
		return arrImage;
	}

	public void setArrImage(List<Images> arrImage) {
		this.arrImage = arrImage;
	}

	public List<Comment> getArrComment() {
		return arrComment;
	}

	public void setArrComment(List<Comment> arrComment) {
		this.arrComment = arrComment;
	}
}
