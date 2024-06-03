package com.example.demos;

import java.util.List;

public class FacturaRepositoryAdapter extends ORMRepository implements FacturaRepository {

	@Override
	public List<Factura> getAll() {
		return get();
	}

	@Override
	public Factura getById(Integer id) {
		// TODO Auto-generated method stub
		return get(id);
	}

	@Override
	public Factura getBy(Factura item) {
		return get(item.getNumeroFactura());
	}

	@Override
	public void add(Factura item) {
		insert(item);
	}

	@Override
	public void modify(Factura item) {
		update(item);
	}

	@Override
	public void remove(Factura item) {
		delete(item);
	}

	@Override
	public void removeById(Integer id) {
		delete(id);
	}

}
