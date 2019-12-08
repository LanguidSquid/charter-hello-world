package com.charter.hello.world.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HelloWorldRequest {
	
	@JsonProperty(value = "message")
	String message;
	
	public HelloWorldRequest() {}
    
    public HelloWorldRequest(String message){
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}
}