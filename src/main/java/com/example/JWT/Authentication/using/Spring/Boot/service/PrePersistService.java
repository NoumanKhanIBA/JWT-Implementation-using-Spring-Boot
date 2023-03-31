package com.example.JWT.Authentication.using.Spring.Boot.service;

import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PrePersistService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //This Method will be executed when the application starts
    @PostConstruct
    public void saveEntity()
    {
        Members adminMember=new Members();
        adminMember.setEmail("abcd@gmail.com");
        adminMember.setPassword(passwordEncoder.encoder().encode("123456"));
        memberRepository.save(adminMember);
    }

}
