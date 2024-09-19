package io.isiflix.security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/auth")
	public String sayAuthHello() {
		return "Hello world security mode!";
	}
}
