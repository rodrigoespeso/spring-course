package com.respeso.springsecurityapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Old auth conf. with no OAuth2
 * 
 *
 * @author Rodrigo Espeso
 *
 */
//@Configuration
//@EnableWebSecurity
public class AppSecurityConfig_old extends WebSecurityConfigurerAdapter {

	
//	@Autowired
	private UserDetailsService userDetailsService; // service layer
	
//	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // Provider -> Service Layer -> DB Layer or DAO (as well as Controller - Service - DAO)
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // provisional, plain text not good
		/*
		 * Must use hash, but it is crackeable.
		 * We can use multiple rounds to encrypt passwords with BCrypt
		 */
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//				.username("rec")
//				.password("rec")
//				.roles("USER")
//				.build()); // Provisional, for learning purpose. We dont use it
//		
//		return new InMemoryUserDetailsManager(users);
//	}
}
