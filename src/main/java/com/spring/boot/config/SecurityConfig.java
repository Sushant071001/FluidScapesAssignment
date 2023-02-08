package com.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {

		UserDetails admin = User.withUsername("sushant")
								.password(passwordEncoder().encode("sush123"))
								.roles("ADMIN")
								.build();

		UserDetails user = User.withUsername("rohan")
								.password(passwordEncoder().encode("rohan123"))
								.roles("USER")
								.build();

		return new InMemoryUserDetailsManager(admin, user);

	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf().disable()
					.authorizeHttpRequests().requestMatchers("/user/**").permitAll()
//					.and()
//					.authorizeHttpRequests().requestMatchers("/user/**").authenticated()
					.and()
					.formLogin()
					.and()
					.build();
					
	}

}
