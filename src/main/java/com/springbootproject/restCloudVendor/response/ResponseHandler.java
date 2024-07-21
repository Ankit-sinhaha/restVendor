package com.springbootproject.restCloudVendor.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus,Object responseObject){


        Map<String,Object> response = new HashMap<>();
        response.put("message",message);
        response.put("httpstatus",httpStatus);
        response.put("data",responseObject);


        return new ResponseEntity<>(response,httpStatus);
    }
}