package com.servicios.soap.model;

import java.util.ArrayList;

public class Herd {
	
	private int id;
	private String name;
	private String location;
	private ArrayList<Cow> cows;
	
	
	public Herd(String name, String location) {
		id = IdHandler.getHerdId();
		this.name = name;
		this.location = location;
		
		cows = new ArrayList<Cow>();
	}

	public boolean addCow(Cow cow) {
		return cows.add(cow);
	}
	
	public boolean removeCow(Cow cow) {
		return cows.remove(cow);
	}
	
	public double getAverageBCS() {
		double sumBCS = 0;
		double tot = 0;
		for(Cow cow : cows) {
			int bcs = cow.getBCS();
			if(bcs != -1) {
				sumBCS += bcs;
				tot++;
			}
		}
		return sumBCS/tot++;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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
		Herd other = (Herd) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
