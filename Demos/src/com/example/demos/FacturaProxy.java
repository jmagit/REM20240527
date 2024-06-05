package com.example.demos;

import java.util.List;

public class FacturaProxy extends Factura {

	public FacturaProxy(int numeroFactura, Cliente cliente) {
		super(numeroFactura, cliente);
	}

	List<Linea> cache = null;

	@Override
	public List<Linea> getLineas() {
		if (cache == null) {
			System.err.println("Tengo lineas?");
			try {
				var fld = getClass().getSuperclass().getDeclaredField("lineas");
				fld.setAccessible(true);
				cache = (List) fld.get(this);
				if (cache == null || cache.size() == 0) {
					System.err.println("Cargo lineas");
					loadLineas();
					cache = (List) fld.get(this);
				}
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return super.getLineas();
	}
//
//	@Override
//	public double getTotal() {
//		if (cache == null) {
//			System.err.println("Cargo lineas");
//			loadLineas();
//			cache = super.getLineas();
//		}
//		return super.getTotal();
//	}
}
