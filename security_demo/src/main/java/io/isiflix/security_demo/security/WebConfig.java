package io.isiflix.security_demo.security;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class WebConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf( (csrf) -> {
			csrf.disable();
		})
		.authorizeHttpRequests( (auth) -> {
			auth.requestMatchers(new AntPathRequestMatcher("/hello", "GET")).permitAll()
			    .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
			    .requestMatchers(new AntPathRequestMatcher("/login", "POST")).permitAll()
			    .requestMatchers(new AntPathRequestMatcher("/buyer", "GET")).hasRole("BUYER")
			    .requestMatchers(new AntPathRequestMatcher("/seller", "GET")).hasRole("SELLER")
			    .requestMatchers(new AntPathRequestMatcher("/sales", "GET")).hasRole("SALES")
			    .requestMatchers(toH2Console()).permitAll()			    
				.anyRequest().authenticated();
		})
		.sessionManagement(customizer -> {
			customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
		.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class)
		.headers( (header) -> header.frameOptions((iframe) -> iframe.disable() ));
		
		return http.build();
	}
	
}
