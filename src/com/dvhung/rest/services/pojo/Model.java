package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Model {
	private int idMo;
	private String nameModel;
	private int idPro;

	public int getIdMo() {
		return idMo;
	}

	public void setIdMo(int idMo) {
		this.idMo = idMo;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
}
