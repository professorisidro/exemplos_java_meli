package br.com.meli.projeto.converter;

import java.util.HashMap;
import java.util.Map;

public class Converter {

	private static Map<String, Character> mapa = new HashMap<String,Character>(){{
		put(".-", 'A');
		put("-..." , 'B');
		put("-.-.", 'C');
		put("-..", 'D');
		put(".", 'E');
		put("..-.", 'F');
		put("--.", 'G');
		put("....", 'H');
		put("..", 'I');
		put(".---", 'J');
		put("-.-", 'K');
		put(".-..", 'L');
		put("--", 'M');
		put("-.", 'N');
		put("---", 'O');
		put(".--.", 'P');
		put("--.-", 'Q');
		put(".-.", 'R');
		put("...", 'S');
		put("-", 'T');
		put("..-", 'U');
		put("...-", 'V');
		put(".--", 'W');
		put("-..-", 'X');
		put("-.--", 'Y');
		put("--..", 'Z');			
	}};
	
	public static Character convertCodeToChar(String code) {
		return mapa.get(code);
	}
	
	public static String convertToWord(String[] letters) {
		String message="";
		for (String letter: letters) {
			message+=convertCodeToChar(letter);
		}
		return message;
	}
}
