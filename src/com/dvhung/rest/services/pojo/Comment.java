package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	private int idCom;
	private String contentComment;
	private int idAcc;
	private int idCar;
	private String userName;

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public String getContentComment() {
		return contentComment;
	}

	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
