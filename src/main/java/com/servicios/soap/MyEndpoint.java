package com.servicios.soap;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;


import com.servicios.DTO.*;

@Endpoint
public class MyEndpoint {
	
 
    private static final String NAMESPACE_URI = "http://www.servicios.com/DTO";
 
    private MyRepository repository;
 
    @Autowired
    public MyEndpoint(MyRepository repository) {
        this.repository = repository;
    }
    
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCowRequest")
    @ResponsePayload
    public CreateCowResponse addCow(@RequestPayload CreateCowRequest request) {
    	Cow cow = request.getCow();
    	int id = repository.addCow(cow.getElectronicId(), cow.getBirthdate(), cow.getWeight());
    	CreateCowResponse response = new CreateCowResponse();
    	cow.setId(new Id(id));
    	response.setCow(cow);
        return response;
    }
    
    private static XMLGregorianCalendar getXmlGregorianCalendarFromDate(final Date date) throws DatatypeConfigurationException{
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCowBCSRequest")
    @ResponsePayload
    public CreateCowBCSResponse addBCS(@RequestPayload CreateCowBCSRequest request) {
    	CowBCS cowbcs = request.getCowbcs();
    	Date date = repository.addBCS(cowbcs.getBCS(), cowbcs.getCowId().getId());
    	CreateCowBCSResponse response = new CreateCowBCSResponse();
    	cowbcs.setDate(getXmlGregorianCalendarFromDate(date));
    	response.setCowbcs(cowbcs);
        return response;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCowInfoRequest")
    @ResponsePayload
    public GetCowInfoResponse getCowInfo(@RequestPayload GetCowInfoRequest request) {
    	Id id = request.getId();
    	com.servicios.soap.model.Cow cow_model = repository.getCow(id.getId());
    	if (cow_model != null) {
    		Cow cow = new Cow();
    		cow.setBirthdate(getXmlGregorianCalendarFromDate(cow_model.getBirthdate()));
    		cow.setId(id));
    		cow.setElectronicId(cow_model.getElectronicId());
    		cow.setWeight(cow_model.getWeight());
    		
    		CowBCS cowbcs = new CowBCS();
    		cowbcs.setBCS(cow_model.getBCS());
    		cowbcs.setCowId(id);
    		cowbcs.setDate(getXmlGregorianCalendarFromDate(cow_model.getBCSDate()));
    		
    		CowInfo cowInfo = new CowInfo();
    		cowInfo.setBsc(cowbcs);
    		cowInfo.setCow(cow);
    	}
        GetCowInfoResponse response = new GetCowInfoResponse();
        
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHerdRequest")
    @ResponsePayload
    public CreateHerdResponse addHerd(@RequestPayload CreateHerdRequest request) {
    	Herd herd = request.getHerd();
    	int id = repository.addHerd(herd.getName(), herd.getLocation());
    	CreateHerdResponse response = new CreateHerdResponse();
    	herd.setId(new Id(id));
    	response.setHerd(herd);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCowToHerdRequest")
    @ResponsePayload
    public AddCowToHerdResponse bindCowHerd(@RequestPayload AddCowToHerdRequest request) {
    	int cowId = request.getCowherdIds().getCowId().getId();
    	int herdId = request.getCowherdIds().getHerdId().getId();
    	boolean binded = repository.bindCowHerd(cowId, herdId);
    	AddCowToHerdResponse response = new AddCowToHerdResponse();
    	response.setBool(binded);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHerdInfoRequest")
    @ResponsePayload
    public GetHerdInfoResponse getHerdInfo(@RequestPayload GetHerdInfoRequest request) {
    	Id id = request.getId();
    	com.servicios.soap.model.Herd herd_model = repository.getHerd(id.getId());
    	if (herd_model != null) {
    		Herd herd = new Herd();
    		herd.setId(id);
    		herd.setName(herd_model.getName());
    		herd.setLocation(herd_model.getLocation());
    		
    		HerdInfo herdInfo = new HerdInfo();
    		herdInfo.setAvgBCS(herd_model.getAverageBCS());
    		herdInfo.setHerd(herd);
    	}
    	
    	
        GetHerdInfoResponse response = new GetHerdInfoResponse();
        
        return response;
    }

 
    

    
}
