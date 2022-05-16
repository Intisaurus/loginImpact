package com.elev8.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.elev8.login.model.Authority;
import com.elev8.login.model.User;
import com.elev8.login.repo.UserDetailsRepo;

@SpringBootApplication
public class LoginImpactApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepo userDetailsRepo;

	public static void main(String[] args) {
		SpringApplication.run(LoginImpactApplication.class, args);
	}
	
	
	@PostConstruct
	protected void init() {
		List<Authority> authorityList = new ArrayList<>();
		
		authorityList.add(createAuthority("USER","User role"));
		authorityList.add(createAuthority("ADMIN","Admin role"));
		
		User user=new User();
		
		user.setUserName("ElsjeS");
		user.setFirstName("Elsje");
		user.setLastName("S");
		
		user.setPassword(passwordEncoder.encode("password"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		
		userDetailsRepo.save(user);
	
	}

	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
