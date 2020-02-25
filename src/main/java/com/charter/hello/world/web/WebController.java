package com.charter.hello.world.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import javax.annotation.Resources;

import com.charter.hello.world.model.HelloWorldResponse;

import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = "/hello",
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseBody HelloWorldResponse hello(){
        return new HelloWorldResponse("Hello World!");
    }
}
