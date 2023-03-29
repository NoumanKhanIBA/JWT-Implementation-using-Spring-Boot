package com.example.JWT.Authentication.using.Spring.Boot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private String jwtToken;
    private String tokenExpiry;
}
