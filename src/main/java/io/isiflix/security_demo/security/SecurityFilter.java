package io.isiflix.security_demo.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecurityFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("Requisicao passou pelo filtro - acessando "+request.getRequestURL());
		
		if (request.getHeader("Authorization") != null) {
			System.out.println("Requisicao vem acompanhada de cabeçalho");
			System.out.println("Cabecalho recebido :"+ request.getHeader("Authorization"));
		    if (request.getHeader("Authorization").equals("Bearer *meli123")) {
		    	Authentication auth =  new UsernamePasswordAuthenticationToken("isidro",null, Collections.emptyList());
		    	SecurityContextHolder.getContext().setAuthentication(auth);
		    }
		}
		filterChain.doFilter(request, response);
		
	}

	
}
