package com.example.demos;

public class FacturaServiceImpl extends ServiceImpl<Factura, Integer> implements FacturaService {

	
	public FacturaServiceImpl() {
		super(new FacturaRepositoryImpl());
	}

	@Override
	protected Repository<Factura, Integer> createRepository() {
		return new FacturaRepositoryImpl();
	}

}
