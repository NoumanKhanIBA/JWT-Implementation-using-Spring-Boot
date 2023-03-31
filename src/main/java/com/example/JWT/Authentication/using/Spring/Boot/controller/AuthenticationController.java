package com.example.JWT.Authentication.using.Spring.Boot.controller;

import com.example.JWT.Authentication.using.Spring.Boot.config.JwtTokenUtil;
import com.example.JWT.Authentication.using.Spring.Boot.request.AddUserRequest;
import com.example.JWT.Authentication.using.Spring.Boot.request.LoginRequest;
import com.example.JWT.Authentication.using.Spring.Boot.response.JwtResponse;
import com.example.JWT.Authentication.using.Spring.Boot.service.JwtUserDetailsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ApiOperation(value = "JWT Token Generation ", notes = "API for Generating Token ")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AddUserRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<JwtResponse>generateToken(@RequestBody LoginRequest loginRequest)
//    {
//      return ResponseEntity.ok(null);
//    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
