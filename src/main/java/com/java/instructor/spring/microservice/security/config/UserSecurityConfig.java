package com.java.instructor.spring.microservice.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // enable method level security 
public class UserSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails instructor = User.withUsername("Sasi")
				.password(passwordEncoder.encode("Password123"))
				.roles("INSTRCTOR")
				.build();
		UserDetails user = User.withUsername("Kumar")
				.password(passwordEncoder.encode("Password456"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(instructor, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.antMatchers("/departments/test").permitAll()
				.antMatchers("/departments/all").hasRole("INSTRCTOR")
				.antMatchers("/departments/**").hasRole("USER")
				.anyRequest().authenticated());
		return http.formLogin().and().build();
	}

}
