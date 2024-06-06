package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.FacturaRepository;
import com.example.domains.contracts.FacturaService;
import com.example.domains.contracts.SaludaService;
import com.example.domains.entities.Rango;
import com.example.domains.services.FacturaServiceImpl;

@SpringBootApplication
public class DemoIoCApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoIoCApplication.class, args);
	}

	@Autowired
	FacturaRepository dao;

	@Autowired(required = false)
	FacturaService srv;
	
	@Autowired
//	@Qualifier("En")
	SaludaService saludaEn;

	@Value("${spring.application.name:Sin nombre}")
	String nombre;
	@Autowired
	private Rango rango;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");

//		dao.getAll().forEach(System.out::println);
		saludaEn.saluda();
		if (srv != null) {
//			srv.getAll().forEach(System.out::println);
			((FacturaServiceImpl) srv).saluda(nombre);
		} else {
			System.out.println("No tengo servicio");
		}
		saludaEn.saluda();
		System.out.println(rango);
	}

}
