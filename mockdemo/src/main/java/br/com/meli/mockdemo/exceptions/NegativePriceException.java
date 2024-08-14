package br.com.meli.mockdemo.exceptions;

public class NegativePriceException extends RuntimeException{
	public NegativePriceException(String msg) {
		super(msg);
	}

}
