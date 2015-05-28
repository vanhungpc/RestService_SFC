package com.dvhung.rest.services.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
	private int idLocal;
	private float lat;
	private float lon;
	private int flagLocal;

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public int getFlagLocal() {
		return flagLocal;
	}

	public void setFlagLocal(int flagLocal) {
		this.flagLocal = flagLocal;
	}


}
