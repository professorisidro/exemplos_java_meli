package br.com.meli.mockdemo.exceptions;

public class ZeroPriceException extends RuntimeException{
	public ZeroPriceException(String msg) {
		super(msg);
	}
}
