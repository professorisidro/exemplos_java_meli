package br.com.meli.projeto.converter;

public class Converter {

	public static char convertCodeToChar(String code) {
		switch(code) {
		case ".-":
			return 'A';
		case "-...":
			return 'B';
		case "-.-.":
			return 'C';
		case "-..":
			return 'D';
		case ".":
			return 'E';
		case "..-.":
			return 'F';
		case "--.":
			return 'G';
		case "....":
			return 'H';
		case "..":
			return 'I';
		case ".---":
			return 'J';
		case "-.-":
			return 'K';
		case ".-..":
			return 'L';
		case "--":
			return 'M';
		case "-.":
			return 'N';
		case "---":
			return 'O';
		case ".--.":
			return 'P';
		case "--.-":
			return 'Q';
		case ".-.":
			return 'R';
		case "...":
			return 'S';
		case "-":
			return 'T';
		case "..-":
			return 'U';
		case "...-":
			return 'V';
		case ".--":
			return 'W';
		case "-..-":
			return 'X';
		case "-.--":
			return 'Y';
		case "--..":
			return 'Z';
		
		default:
			return '\0';			
		}
	}
	
	public static String convertToWord(String[] word) {
		String message="";
		for (String letter: word) {
			message+=convertCodeToChar(letter);
		}
		return message;
	}
}
