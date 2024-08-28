package br.com.meli.validademo;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class FuncionarioController {

	@PostMapping("/funcionario")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid FuncionarioDTO func, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(
				new ErrorMessage(Erros.CONTEUDO_VAZIO,
						         errors.getAllErrors().get(0).getDefaultMessage()));
		}
		return ResponseEntity.ok(func);
	}

	

}
