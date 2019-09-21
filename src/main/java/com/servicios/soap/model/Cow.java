package com.servicios.soap.model;

import java.util.Date;

public class Cow {
	
	
	private int id;
	private int bcs;
	private Date bcsDate;
	private int electronicId;
	private Date birthdate;
	private double weight;
	
	
	public Cow(int electronicId, Date birthdate, double weight) {
		id = IdHandler.getCowId();
		bcs = -1;
		bcsDate = null;
		this.electronicId = electronicId;
		this.birthdate = birthdate;
		this.weight = weight;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBCS() {
		return bcs;
	}


	public void setBCS(int bcs) {
		this.bcs = bcs;
		bcsDate = new Date();
	}

	

	public Date getBCSDate() {
		return bcsDate;
	}


	public void setBCSDate(Date bcsDate) {
		this.bcsDate = bcsDate;
	}


	public int getElectronicId() {
		return electronicId;
	}


	public void setElectronicId(int electronicId) {
		this.electronicId = electronicId;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cow other = (Cow) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
