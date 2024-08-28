package br.com.meli.profiles;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProdutoServiceTest {
	
	@Autowired 
	private ProdutoRepo repo;
	
	@Autowired
	private IProdutoService service;
	
	private Produto p1 = new Produto(5,"Mesa", 600.0);
	private List<Produto> lista = new ArrayList<Produto>() {{
		add(new Produto(1,"Computador", 1500.0));
		add(new Produto(2,"Mouse", 50.0));
		add(new Produto(3,"Teclado", 100.0));
		add(new Produto(4,"Monitor", 500.0));
	}};
	
/*	@BeforeEach
	public void setup() {
		Mockito.when(repo.create(p1)).thenReturn(p1);
		Mockito.when(repo.findAll()).thenReturn(lista);
	}
*/
	
	@Test
	public void shouldNotAddNewProduct() {
		Assertions.assertNotNull(service.adicionarNovo(p1));
		System.out.println(repo.findAll().size());
	}
}
