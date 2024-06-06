package com.example.domains.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.SaludaService;

@Service
@Qualifier("Es")
public class SaludaServiceEsImpl implements SaludaService {
	private String nombre = "mundo";

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void saluda() {
		System.out.println("Hola " + nombre);
	}

}
