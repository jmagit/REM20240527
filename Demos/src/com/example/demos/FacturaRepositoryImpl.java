package com.example.demos;

import java.sql.SQLException;
import java.util.List;

public class FacturaRepositoryImpl implements FacturaRepository {
	@Override
	public List <Factura> getAll() {
		return null;
	}
	@Override
	public Factura getById(Integer id) {
		try {
			var x =  JDBCSingleton.getInstance();
			x.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		
	}
	
}
