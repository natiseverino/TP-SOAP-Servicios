package com.servicios.soap;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.servicios.soap.model.*;

@Component
public class MyRepository {
	 
    private ArrayList<Cow> cows;
    private ArrayList<Herd> herds;
    
    /*
    @PostConstruct
    public void initData() {
    }
	*/
    
    public MyRepository() {
    	cows = new ArrayList<>();
    	herds = new ArrayList<>();
    }
    
    public int addCow(int electronicId, Date birthdate, double weight) {
    	Cow cow = new Cow(electronicId, birthdate, weight);
    	cows.add(cow);
    	return cow.getId();
    }
    
    public Date addBCS(int bcs, int cowId) {
    	for(Cow cow : cows)
    		if(cow.getId() == cowId)
    			cow.setBCS(bcs);
    	return new Date();
    }
    
    
    public int addHerd(String name, String location) {
    	Herd herd = new Herd(name, location);
    	herds.add(herd);
    	return herd.getId();
    }
    
    public boolean bindCowHerd(int cowId, int herdId) {
    	
    	Cow cow = null;
    	Herd herd = null;

    	for(Cow actualCow : cows)
    		if(actualCow.getId() == cowId)
    			cow = actualCow;
    	
    	for(Herd actualHerd : herds)
    		if(actualHerd.getId() == herdId)
    			herd = actualHerd;
    	
    	
    	if(cow == null || herd == null)
    	    	return false;
    	else {
    		herd.addCow(cow);    		
    		return true;
    	}
    }
    
    public Cow getCow(int cowId){
    	for(Cow cow : cows)
    		if(cow.getId() == cowId)
    			return cow;
    	return null;
    }
    
    public Herd getHerd(int herdId){
    	for(Herd herd : herds)
    		if(herd.getId() == herdId)
    			return herd;
    	return null;
    }
    

}
