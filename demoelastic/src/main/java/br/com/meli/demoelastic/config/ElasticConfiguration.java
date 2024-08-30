package br.com.meli.demoelastic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticConfiguration extends ElasticsearchConfiguration{

	@Override
	public ClientConfiguration clientConfiguration() {
		// TODO Auto-generated method stub
		System.out.println("Configurando conexao com ELASTIC");
		
		return ClientConfiguration.builder()
				.connectedTo("localhost:9200")
				.usingSsl("8b29703fb7e76d420feb6ed384b5affb41afd9230ecc2acd84e5e142672759a7")
				.withBasicAuth("elastic", "-9AZSytwOd=AXo0PVJPU")
				.build();
	}

}
