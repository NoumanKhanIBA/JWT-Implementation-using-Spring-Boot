package com.example.JWT.Authentication.using.Spring.Boot.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty(message = "Please provide Username")
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotEmpty(message = "Please provide password")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
