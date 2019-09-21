package com.servicios.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;


import com.servicios.DTO.*;


@Endpoint
public class MyEndpoint {
	
 
    private static final String NAMESPACE_URI = "http://www.example.org/carpintero_severino";
 
    private MyRepository repository;
 
    @Autowired
    public MyEndpoint(MyRepository repository) {
        this.repository = repository;
    }
    
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCowRequest")
    @ResponsePayload
    public CreateCowResponse addCow(@RequestPayload CreateCowRequest request) {
    	CreateCowResponse response = new CreateCowResponse();
   
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCowBCSRequest")
    @ResponsePayload
    public CreateCowBCSResponse addBCS(@RequestPayload CreateCowBCSRequest request) {
    	CreateCowBCSResponse response = new CreateCowBCSResponse();
        return response;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCowInfoRequest")
    @ResponsePayload
    public GetCowInfoResponse getCowInfo(@RequestPayload GetCowInfoRequest request) {
        GetCowInfoResponse response = new GetCowInfoResponse();
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHerdRequest")
    @ResponsePayload
    public CreateHerdResponse addHerd(@RequestPayload CreateHerdRequest request) {
    	CreateHerdResponse response = new CreateHerdResponse();
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCowToHerdRequest")
    @ResponsePayload
    public AddCowToHerdResponse linkCowHerd(@RequestPayload AddCowToHerdRequest request) {
    	AddCowToHerdResponse response = new AddCowToHerdResponse();
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHerdInfoRequest")
    @ResponsePayload
    public GetHerdInfoResponse getHerdInfo(@RequestPayload GetHerdInfoRequest request) {
        GetHerdInfoResponse response = new GetHerdInfoResponse();
        return response;
    }

 
    

    
}
