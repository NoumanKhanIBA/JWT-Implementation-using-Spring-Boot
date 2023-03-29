package com.example.JWT.Authentication.using.Spring.Boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-api")
    public ResponseEntity<String>testApi()
    {

        return ResponseEntity.status(HttpStatus.OK).body("Welcome To APP.");
    }
}
