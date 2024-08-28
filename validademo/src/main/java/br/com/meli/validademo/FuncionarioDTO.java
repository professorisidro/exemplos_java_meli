package br.com.meli.validademo;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FuncionarioDTO(@NotNull(message = "Codigo nao pode ser vazio") 
							 @Min(value = 0, message = "Codigo precisa ser positivo") 
							 Integer codigo, 
		                     @NotNull(message = "Nome é campo obrigatorio") 
		                     @Size(min = 10, max = 50, message = "Numero de caracteres entre 10 e 50") 
							 @NotEmpty (message = "Nome nao pode ser vazio") 
							 String nome, 
		                     @NotNull(message="Email é campo obrigatorio") 
							 @Email(message = "Precisa seguir o padrão de email xxx@yyy.zzz" )
							 String email) {

}
