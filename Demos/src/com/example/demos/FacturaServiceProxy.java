package com.example.demos;

public class FacturaServiceProxy extends ServiceImpl<Factura, Integer> implements FacturaService {

	
	public FacturaServiceProxy() {
		super(new FacturaRepositoryProxy());
	}

	@Override
	protected Repository<Factura, Integer> createRepository() {
		return new FacturaRepositoryProxy();
	}

}
