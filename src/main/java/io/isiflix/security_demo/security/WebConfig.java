package io.isiflix.security_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
				.anyRequest().authenticated();
		})
		.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
}
