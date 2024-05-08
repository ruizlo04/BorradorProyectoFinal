package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
	}

    
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**")
				.permitAll().anyRequest().authenticated())
			.formLogin((loginz) -> loginz
					.loginPage("/trenes/mostrarLogin").permitAll());
    	http.csrf(csrfz -> csrfz.disable());
    	http.headers(headersz -> headersz
    			.frameOptions(frameOptionsz -> frameOptionsz.disable()));
		
		return http.build();
	}


}
