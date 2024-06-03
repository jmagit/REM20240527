package com.example.demos;

import java.sql.SQLException;
import java.util.List;

public class ORMRepository {
	public List <Factura> get() {
		return null;
	}
	public Factura get(Integer id) {
		try {
			var x =  JDBCSingleton.getInstance();
			x.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final void insert(Factura item) {
		
	}
	
	public void update(Factura item) {
		
	}
	
	public void delete(Factura item) {
		
	}
	
	public void delete(Integer id) {
		System.out.println("Implemetacion distinta");
	}

}
