package com.servicios.soap;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.servicios.soap.model.*;

@Component
public class MyRepository {
	 
    private static final Map<Integer, Cow> cows = new HashMap<>();
    
    @PostConstruct
    public void initData() {
        // initialize countries map
    }


}
