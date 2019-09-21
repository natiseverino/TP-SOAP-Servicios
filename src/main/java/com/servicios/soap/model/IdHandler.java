package com.servicios.soap.model;

import java.util.Date;

public class IdHandler {
	
	private static int actualCowId = 0;
	private static int actualHerdId = 0;
	
	public static synchronized int getCowId()
	{
	    return actualCowId++;
	}
	
	public static synchronized int getHerdId()
	{
	    return actualHerdId++;
	}
	
	
	public static void main(String[] args) {
	}

}
