package br.com.meli.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${meli.value}")
	private String msg;
	
	@GetMapping("/hello")
	public String sayHello() {
		return msg;
	}
}
