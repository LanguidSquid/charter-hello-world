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
        return new HelloWorldResponse(getMessage());
    }

    @PostMapping(value = "/hello",
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseBody HelloWorldResponse postHello(@RequestBody HelloWorldResponse helloWorldResponse){
        setMessage(helloWorldResponse.getMessage());
        return helloWorldResponse;
    }

    private String getMessage() {
        String message = null;
        try {
            message = readFromInputStream(new FileInputStream(ResourceUtils.getFile("classpath:message.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(message)) {
            return "Hello World!";
        }
        return message;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line);
            }
        }
        return resultStringBuilder.toString();
    }

    private void setMessage(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ResourceUtils.getFile("classpath:message.txt")))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
