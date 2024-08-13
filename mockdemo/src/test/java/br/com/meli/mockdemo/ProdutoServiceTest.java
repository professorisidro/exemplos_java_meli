package br.com.meli.mockdemo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.mockdemo.service.IProdutoService;

@SpringBootTest
public class ProdutoServiceTest {

//	@MockBean
	@Autowired
	private IProdutoService service;
	
//	@BeforeEach
//	public void setupTestes() throws Exception{
//		// como eu quero que o meu serviço se comporte
//		Mockito.when(service.getProdutoById(1)).thenReturn(new Produto(1, "Computador", 1500.0));
//		Mockito.when(service.getProdutoById(2)).thenReturn(new Produto(2, "Teclado", 100.0));
//		Mockito.when(service.getProdutoById(100)).thenReturn(null);
//		Mockito.when(service.getProdutoById(-1)).thenThrow(new RuntimeException("ID Invalido"));
//	}
	
	
	@Test
	public void testandoSeProduto1Existe() {
		Assertions.assertNotNull(service.getProdutoById(1));	
	}
	@Test
	public void testandoSeProduto2Existe() {
		Assertions.assertEquals(service.getProdutoById(2).getId(), 2);	
	}
	@Test
	public void testandoSeProduto100Inexiste() {
		Assertions.assertNull(service.getProdutoById(100));	
	}	
	@Test
	public void testandoIdInvalido() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			service.getProdutoById(-1);	
		});
	}
	
	// testes simulando as chamadas do controller
	
	
	
	
	
	
}
