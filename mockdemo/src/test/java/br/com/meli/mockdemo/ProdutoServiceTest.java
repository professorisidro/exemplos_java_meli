package br.com.meli.mockdemo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.mockdemo.entity.Produto;
import br.com.meli.mockdemo.exceptions.NegativePriceException;
import br.com.meli.mockdemo.exceptions.NoDataException;
import br.com.meli.mockdemo.exceptions.NullDescriptionException;
import br.com.meli.mockdemo.exceptions.ZeroPriceException;
import br.com.meli.mockdemo.service.IProdutoService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoServiceTest {
	
	@Autowired
	private MockMvc mvc;

//	@MockBean
	@Autowired
	private IProdutoService service;
	
	private Produto produtoCorreto;
	private Produto produtoPrecoZerado;
	private Produto produtoSemDescricao;
	private Produto produtoPrecoNegativo;
	private Produto produtoSemPrecoSemDescricao;
	
	@BeforeEach
	public void setupTestes() throws Exception{
		
		produtoCorreto = new Produto(10,"Produto 10", 100.0);
		produtoPrecoZerado = new Produto(11,"Produto 10", 0.0);
		produtoSemDescricao = new Produto(12, null, 100.0);
		produtoPrecoNegativo = new Produto(13, "Produto 10 ", -1000.0);
		produtoSemPrecoSemDescricao = new Produto(14, null, null);
		
		// como eu quero que o meu serviço se comporte
//		Mockito.when(service.getProdutoById(1)).thenReturn(new Produto(1, "Computador", 1500.0));
//		Mockito.when(service.getProdutoById(2)).thenReturn(new Produto(2, "Teclado", 100.0));
//		Mockito.when(service.getProdutoById(100)).thenReturn(null);
//		Mockito.when(service.getProdutoById(-1)).thenThrow(new RuntimeException("ID Invalido"));
//		Mockito.when(service.adicionarProduto(produtoCorreto)).thenReturn(produtoCorreto);
//		Mockito.when(service.adicionarProduto(produtoPrecoZerado)).thenThrow(new ZeroPriceException("Produto com preço invalido"));
//		Mockito.when(service.adicionarProduto(produtoSemDescricao)).thenThrow(new NullDescriptionException("Produto sem Descricao"));
//		Mockito.when(service.adicionarProduto(produtoPrecoNegativo)).thenThrow(new NegativePriceException("Preco nao pode ser negativo"));
//		Mockito.when(service.adicionarProduto(produtoSemPrecoSemDescricao)).thenThrow(new NoDataException("Dados incompletos"));
	}
	
	
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
	
	// alguns testes para adicionar produtos
	@Test
	public void shouldAdicionarProdutoAndExpectOk() {
		Assertions.assertNotNull(service.adicionarProduto(produtoCorreto));
	}
	
	@Test
	public void shouldNotAdicionarProdutoAndNotifyZeroPrice() {
		Assertions.assertThrows(ZeroPriceException.class, () -> {
			service.adicionarProduto(produtoPrecoZerado);
		});
	}
	
	
	@Test
	public void shouldNotAdicionarProdutoAndNotifyNegativePrice() {
		Assertions.assertThrows(NegativePriceException.class, () -> {
			service.adicionarProduto(produtoPrecoNegativo);
		});
	}
	
	@Test
	public void shouldNotAdicionarProdutoAndNotifyNullDescription() {
		Assertions.assertThrows(NullDescriptionException.class, () -> {
			service.adicionarProduto(produtoSemDescricao);
		});
	}
	
	@Test
	public void shouldNotAdicionarProdutoAndNotifyNoData() {
		Assertions.assertThrows(NoDataException.class, () -> {
			service.adicionarProduto(produtoSemPrecoSemDescricao);
		});
	}
	
	
	// testes simulando as chamadas do controller
	
	@Test
	public void shouldGetProdutoAndReturnStatusOk() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/produtos/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@Test
	public void sholdNotGetProdutoAndReturnStatusNotFound() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/produtos/100"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void shouldNotGetProdutoAndReturnStatusBadRequest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/produtos/-1"))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test 
	public void shouldPostProductAndReturnStatusCreated() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String strProduto = mapper.writeValueAsString(produtoCorreto);
		mvc.perform(MockMvcRequestBuilders.post("/produtos")
				                          .contentType(MediaType.APPLICATION_JSON)
				                          .content(strProduto))
		   .andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	@Test 
	public void shouldNotPostProductAndReturnStatusBadRequestDueToZeroPrice() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String strProduto = mapper.writeValueAsString(produtoPrecoZerado);
		mvc.perform(MockMvcRequestBuilders.post("/produtos")
				                          .contentType(MediaType.APPLICATION_JSON)
				                          .content(strProduto))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test 
	public void shouldNotPostProductAndReturnStatusBadRequestDueToNegativePrice() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String strProduto = mapper.writeValueAsString(produtoPrecoNegativo);
		mvc.perform(MockMvcRequestBuilders.post("/produtos")
				                          .contentType(MediaType.APPLICATION_JSON)
				                          .content(strProduto))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test 
	public void shouldNotPostProductAndReturnStatusBadRequestDueToNullName() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String strProduto = mapper.writeValueAsString(produtoSemDescricao);
		mvc.perform(MockMvcRequestBuilders.post("/produtos")
				                          .contentType(MediaType.APPLICATION_JSON)
				                          .content(strProduto))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
		
	@Test 
	public void shouldNotPostProductAndReturnStatusBadRequestDueToNoData() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String strProduto = mapper.writeValueAsString(produtoSemPrecoSemDescricao);
		mvc.perform(MockMvcRequestBuilders.post("/produtos")
				                          .contentType(MediaType.APPLICATION_JSON)
				                          .content(strProduto))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
}
