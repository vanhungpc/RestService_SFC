package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarLine {
	private int idCarline;
	private String nameCarline;

	public int getIdCarline() {
		return idCarline;
	}

	public void setIdCarline(int idCarline) {
		this.idCarline = idCarline;
	}

	public String getNameCarline() {
		return nameCarline;
	}

	public void setNameCarline(String nameCarline) {
		this.nameCarline = nameCarline;
	}
}
