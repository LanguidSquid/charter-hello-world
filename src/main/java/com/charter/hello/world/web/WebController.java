package com.charter.hello.world.web;

import com.charter.hello.world.model.HelloWorldResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = "/hello",
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseBody HelloWorldResponse hello(){
        HelloWorldResponse response = new HelloWorldResponse("Hello World!");

        System.out.println(response.getMessage());

        return new HelloWorldResponse("Hello World!");
    }
}
