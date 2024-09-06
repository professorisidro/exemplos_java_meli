package br.com.isiflix.veiculos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.isiflix.veiculos.exceptions.ValidacaoException;

@ControllerAdvice
public class VeiculoControllerAdvice {

	@ExceptionHandler(value = ValidacaoException.class)
	public ResponseEntity<?> veiculoInvalidoException(){
		return new ResponseEntity<String>("Erro!!!", HttpStatus.BAD_REQUEST);
	}
}
