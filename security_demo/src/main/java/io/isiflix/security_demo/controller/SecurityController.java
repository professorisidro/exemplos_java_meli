package io.isiflix.security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/buyer")
	public String sayHelloToBuyer() {
		return "Hello World, Buyer!";
	}
	@GetMapping("/seller")
	public String sayHelloToSeller() {
		return "Hello World, Seller!";
	}
	@GetMapping("/sales")
	public String sayHelloToSales() {
		return "Hello World, Sales Representative!";
	}
	
	@GetMapping("/auth")
	public String sayHelloToEveryone() {
		return "Hello World Everyone!!!";
	}
}
