package br.com.meli.projeto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.projeto.converter.Converter;
import br.com.meli.projeto.dto.HumanMessage;
import br.com.meli.projeto.dto.MorseMessage;

@RestController
public class MorseController {
	
	@PostMapping("/decode")
	public HumanMessage decodeFromMorse(@RequestBody MorseMessage message) {
		String phrase = "";
		for (String words: message.code().split("   ")) {
			phrase += Converter.convertToWord(words.split(" ")) + " ";
		}
		return new HumanMessage(phrase);
	}

}
