package com.example.JWT.Authentication.using.Spring.Boot.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddUserRequest {
    @NotEmpty(message = "Please provide Username")
    @NotBlank(message = "Username cannot be blank")
    @Email(message = "Please provide valid Email")
    private String email;
    @NotEmpty(message = "Please provide password")
    @NotBlank(message = "Password cannot be blank")
    @Size(min= 6,message = "Password should have minimum 6 characters")
    private String password;
}
