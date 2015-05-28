package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Domain {
	private int idDo;
	private String nameDomain;

	public int getIdDo() {
		return idDo;
	}

	public void setIdDo(int idDo) {
		this.idDo = idDo;
	}

	public String getNameDomain() {
		return nameDomain;
	}

	public void setNameDomain(String nameDomain) {
		this.nameDomain = nameDomain;
	}
}
