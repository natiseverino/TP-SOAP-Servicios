package com.servicios.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.servicios.DAO.CreateCowBCSRequest;
import com.servicios.DAO.CreateCowBCSResponse;
import com.servicios.DAO.GetCowInfoRequest;
import com.servicios.DAO.GetCowInfoResponse;
import com.servicios.DAO.GetHerdInfoRequest;
import com.servicios.DAO.GetHerdInfoResponse;

@Endpoint
public class MyEndpoint {
	
 
    private static final String NAMESPACE_URI = "http://www.example.org/carpintero_severino";
 
    private MyRepository repository;
 
    @Autowired
    public MyEndpoint(MyRepository repository) {
        this.repository = repository;
    }
    
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCowInfoRequest")
    @ResponsePayload
    public GetCowInfoResponse getCowInfo(@RequestPayload GetCowInfoRequest request) {
        GetCowInfoResponse response = new GetCowInfoResponse();
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHerdInfoRequest")
    @ResponsePayload
    public GetHerdInfoResponse getHerdInfo(@RequestPayload GetHerdInfoRequest request) {
        GetHerdInfoResponse response = new GetHerdInfoResponse();
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCowBCSRequest")
    @ResponsePayload
    public CreateCowBCSResponse addBCS(@RequestPayload CreateCowBCSRequest request) {
    	CreateCowBCSResponse response = new CreateCowBCSResponse();
        return response;
    }
    
}
