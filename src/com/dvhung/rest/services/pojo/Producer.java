package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producer {
	private int idPro;
	private String nameProducer;

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getNameProducer() {
		return nameProducer;
	}

	public void setNameProducer(String nameProducer) {
		this.nameProducer = nameProducer;
	}
}
