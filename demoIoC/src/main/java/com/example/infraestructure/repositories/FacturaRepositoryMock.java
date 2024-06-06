package com.example.infraestructure.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.domains.contracts.FacturaRepository;
import com.example.domains.entities.Cliente;
import com.example.domains.entities.Factura;

//@Component
public class FacturaRepositoryMock implements FacturaRepository {

	@Override
	public List<Factura> getAll() {
		System.err.println("Simulacion de acceso a base de datos");
		return List.of(new Factura(2, Cliente.getBuilder().razonSocial("Simulada S.L.").addCorreo("kk@local.es").build()));
	}

	@Override
	public Factura getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Factura getBy(Factura item) {
		return getById(item.getNumeroFactura());
	}

	@Override
	public void add(Factura item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Factura item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Factura item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeById(Integer id) {
		System.out.println("Simulo que borro");

	}

}
