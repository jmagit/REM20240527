package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domains.contracts.SaludaService;
import com.example.domains.services.SaludaServiceEnImpl;
import com.example.domains.services.SaludaServiceEsImpl;

@Configuration
public class MyConfig {

	@Bean() String autor() { return "Yo mismo"; }
	
//	@Bean()
//	SaludaService saludaEs() {
//		return new SaludaServiceEsImpl();
//	}
//	
//	@Bean()
//	SaludaService saludaEn() {
//		return new SaludaServiceEnImpl();
//	}
	@Bean()
	SaludaService saludaEs(@Qualifier("Es") SaludaService saluda) {
		return saluda;
	}
	@Bean()
	SaludaService saludaEn(@Qualifier("En") SaludaService saluda) {
		return saluda;
	}

}
