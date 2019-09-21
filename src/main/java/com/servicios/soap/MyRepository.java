package com.servicios.soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    
    
    
    

}
