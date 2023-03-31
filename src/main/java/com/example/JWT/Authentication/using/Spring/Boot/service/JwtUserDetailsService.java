package com.example.JWT.Authentication.using.Spring.Boot.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Members> user = memberRepository.findByEmail(username);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.get().getEmail(), user.get().getPassword(),
				new ArrayList<>());
	}
}