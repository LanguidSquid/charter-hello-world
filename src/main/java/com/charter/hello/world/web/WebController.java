package com.charter.hello.world.web;

import com.charter.hello.world.model.HelloWorldResponse;
import com.charter.hello.world.model.HelloWorldRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	//Use this to store Post message that Get will return
	//Initialize it to Hello World
	private String message = "Hello World";
	
	//Get request
    @GetMapping(value = "/hello",
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseBody HelloWorldResponse hello(){
        return new HelloWorldResponse(message);
    }
    
    //Post request
    @PostMapping(value = "/hello",
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseBody HelloWorldResponse create(@RequestBody HelloWorldRequest request){
    	//Update message to the request
    	message = request.getMessage();
        return new HelloWorldResponse(message);
    }
}
