package com.example.demos;

import java.sql.SQLException;
import java.util.List;

public class FacturaRepositoryProxy implements FacturaRepository {
	List<Factura> cache;

	@Override
	public List<Factura> getAll() {
		System.err.println("Consultando al remoto");
		if (cache == null)
			cache = List.of(new FacturaProxy(1,
					Cliente.getBuilder().razonSocial("ACME S.L.").addCorreo("kk@acme.com").build()));
		return cache;
	}

	@Override
	public Factura getById(Integer id) {
		return getAll().get(0);
	}

	@Override
	public Factura getBy(Factura item) {
		return getById(item.getNumeroFactura());
	}

	@Override
	public final void add(Factura item) {

	}

	@Override
	public void modify(Factura item) {

	}

	@Override
	public void remove(Factura item) {

	}

	@Override
	public void removeById(Integer id) {
		System.out.println("Borro en la base de datos");
	}

}
