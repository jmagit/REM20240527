package com.example.demos;

import java.util.List;

public class FacturaRepositoryMock implements FacturaRepository {

	@Override
	public List<Factura> getAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

}
