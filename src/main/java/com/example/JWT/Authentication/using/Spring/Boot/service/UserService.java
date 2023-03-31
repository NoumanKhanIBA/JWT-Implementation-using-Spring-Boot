package com.example.JWT.Authentication.using.Spring.Boot.service;


import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.request.AddUserRequest;

import java.util.List;

public interface UserService {

    public Members createUser(AddUserRequest addUserRequest) throws Exception;

    public Members getUser(Long id) ;

   List<Members> getUsers();
}
