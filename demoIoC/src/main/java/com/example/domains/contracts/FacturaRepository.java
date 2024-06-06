package com.example.domains.contracts;

import java.util.List;

import com.example.domains.entities.Factura;

public interface FacturaRepository extends Repository<Factura, Integer> {
	
}

//public interface FacturaRepository {
//
//	List<Factura> getAll();
//
//	Factura getById(Integer id);
//
//	void add(Factura item);
//
//	void modify(Factura item);
//
//	void remove(Factura item);
//
//	void removeById(Integer id);
//
//}