package com.example.infraestructure.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domains.contracts.FacturaRepository;
import com.example.domains.entities.Cliente;
import com.example.domains.entities.Factura;

@Repository
public class FacturaRepositoryImpl implements FacturaRepository {
	@Override
	public List <Factura> getAll() {
		System.err.println("Consultando la base de datos local");
		return List.of(new Factura(2, Cliente.getBuilder().razonSocial("Local S.L.").addCorreo("kk@local.es").build()));
	}
	@Override
	public Factura getById(Integer id) {
//		try {
//			var x =  JDBCSingleton.getInstance();
//			x.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
