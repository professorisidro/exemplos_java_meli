package br.com.melli.covid.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.melli.covid.dto.PessoaResponseDTO;
import br.com.melli.covid.dto.SintomaResponseDTO;
import br.com.melli.covid.model.Pessoa;
import br.com.melli.covid.model.Sintoma;

public class FakeBD {
	
	public static Pessoa pessoa = new Pessoa() {{
		setId(9876);
		setNome("Professor Isidro");
		setSobrenome("Massetto");
		setIdade(45);
		setSintomas(Arrays.asList(new Sintoma(123, "Febre", 8),
								  new Sintoma(124, "Tosse", 5),
								  new Sintoma(125, "Cefaleia", 7),
								  new Sintoma(126, "Diarreia", 9)));
	}};
	
	public static List<SintomaResponseDTO> getAllSintomas(){
		List<SintomaResponseDTO> resp = new ArrayList<SintomaResponseDTO>();
		for (Sintoma s: pessoa.getSintomas()) {
			resp.add(new SintomaResponseDTO(s.getNome(), s.getNivelDeGravidade()));
		}
		return resp;
	}
	
	public static PessoaResponseDTO encontrarSintomaNaPessoa(String sintoma) {
		for (Sintoma s: pessoa.getSintomas()) {
			if (s.getNome().equals(sintoma)) {
				return new PessoaResponseDTO(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade());
			}
		}
		return null;
	}

}
