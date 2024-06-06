package com.example.domains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.FacturaRepository;
import com.example.domains.contracts.FacturaService;
import com.example.domains.contracts.SaludaService;
import com.example.domains.entities.Factura;

import jakarta.annotation.PostConstruct;

@Service
public class FacturaServiceImpl extends ServiceImpl<Factura, Integer> implements FacturaService {

	private SaludaService dao;

	public FacturaServiceImpl(FacturaRepository repository, SaludaService saludaEs, String autor) {
		super(repository);
		dao = saludaEs;
		dao.setNombre(autor);
	}

//	@PostConstruct
//	private void loQueFalta() {
//		dao.setNombre("Servicio");
//	}
	public void saluda() {
		dao.saluda();
	}

	public void saluda(String nombre) {
		dao.setNombre(nombre);
		dao.saluda();
	}

}
