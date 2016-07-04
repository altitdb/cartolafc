package com.globo.cartolafc.config;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication(scanBasePackages = "com.globo.cartolafc")
public class Application {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        SpringApplication.run(Application.class, args);
    }

}