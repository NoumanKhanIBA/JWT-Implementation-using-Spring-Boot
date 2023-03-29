package com.example.JWT.Authentication.using.Spring.Boot.controller;

import com.example.JWT.Authentication.using.Spring.Boot.request.LoginRequest;
import com.example.JWT.Authentication.using.Spring.Boot.response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse>generateToken(@RequestBody LoginRequest loginRequest)
    {
      return ResponseEntity.ok(null);
    }
}
