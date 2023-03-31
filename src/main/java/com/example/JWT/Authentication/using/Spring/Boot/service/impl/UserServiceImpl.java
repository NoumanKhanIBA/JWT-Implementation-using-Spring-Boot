package com.example.JWT.Authentication.using.Spring.Boot.service.impl;

import com.example.JWT.Authentication.using.Spring.Boot.Exception.UserNotFoundException;
import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.repository.MemberRepository;
import com.example.JWT.Authentication.using.Spring.Boot.request.AddUserRequest;
import com.example.JWT.Authentication.using.Spring.Boot.service.PasswordEncoder;
import com.example.JWT.Authentication.using.Spring.Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Members createUser(AddUserRequest userRequest) throws Exception {


        Optional<Members> usersOptional = memberRepository.findByEmail(userRequest.getEmail());
        if (usersOptional.isPresent()) {
            throw new Exception("User with an email :" + userRequest.getEmail() + " already exists. Duplicate email not allowed.");
        }

        Members members = new Members();
        members.setEmail(userRequest.getEmail());
        members.setPassword(passwordEncoder.encoder().encode(userRequest.getPassword()));
        members= memberRepository.save(members);
        return members;
    }

    @Override
    public Members getUser(Long id) {
        Optional<Members> users = memberRepository.findById(id);
        if (users.isPresent()) {
            return users.get();
        } else {
            throw new UserNotFoundException("The user  is not available with id:" + id);

        }
    }

    @Override
    public List<Members> getUsers() {
        List<Members> membersList = memberRepository.findAll();
        if (membersList.size() == 0) {
            throw new UserNotFoundException("Users are not available in DB");

        } else {
            return membersList;
        }
    }
}
