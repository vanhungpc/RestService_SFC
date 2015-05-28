package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {
	private int idCity;
	private String nameCity;
	private int idDo;

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public int getIdDo() {
		return idDo;
	}

	public void setIdDo(int idDo) {
		this.idDo = idDo;
	}
}
