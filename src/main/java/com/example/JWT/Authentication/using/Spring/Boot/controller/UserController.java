package com.example.JWT.Authentication.using.Spring.Boot.controller;

import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.request.AddUserRequest;
import com.example.JWT.Authentication.using.Spring.Boot.service.ApiResponse;
import com.example.JWT.Authentication.using.Spring.Boot.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    @ApiOperation(value = "API for saving a user into db",authorizations = {
            @Authorization(value = "jwtToken") })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "New something successfully created"),
            @io.swagger.annotations.ApiResponse(code = 422, message = "Duplicate Email not Allowed"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(CREATED)
    public ResponseEntity<ApiResponse<Members>>addUser(@Valid @RequestBody AddUserRequest userRequest)
    {
        try {
            return ResponseEntity.status(CREATED).
                    body(ApiResponse.successWithPayload(userService.createUser(userRequest),"User added Successfully."));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.failure(e.getMessage()));
        }

    }


    @GetMapping("/{id}")
    @ApiOperation(value = "API for fetching a user from db",authorizations = {
            @Authorization(value = "jwtToken") })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "User fetched Successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "User not found in DB with given ID"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(OK)
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @GetMapping("")
    @ApiOperation(value = "API for fetching all Users from db",authorizations = {
            @Authorization(value = "jwtToken") })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Users fetched Successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Users not found in DB "),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(OK)
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

}
