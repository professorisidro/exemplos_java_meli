package io.isiflix.security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFreeController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
}
