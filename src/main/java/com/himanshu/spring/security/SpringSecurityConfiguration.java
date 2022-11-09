package com.himanshu.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// All request should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		// show popup
		http.httpBasic(withDefaults());

		// post and put request hand;ling
		http.csrf().disable();
		return http.build();

	}
}
