package com.dvhung.rest.services.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -956910915661143062L;
	private int idAcc;
	private String name;
	private String password;
	private String birthDay;
	private String address;
	private int phoneNumber;
	private String email;
	private String avatar;

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}
