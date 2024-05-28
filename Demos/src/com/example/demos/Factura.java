package com.example.demos;

import java.util.ArrayList;
import java.util.List;

public class Factura {
	public static enum Estado {
		PENDIENTE, CANCELADA, PAGADA
	}
	
	private int numeroFactura;
	private List<Linea> lineas = new ArrayList<>();
	
	public class Linea {
		private int cantida;
		private double precio;
		private String concepto;
		
		public Linea(int cantida, double precio, String concepto) {
			super();
			this.cantida = cantida;
			this.precio = precio;
			this.concepto = concepto;
		}
		public int getCantida() {
			return cantida;
		}
		public void setCantida(int cantida) {
			this.cantida = cantida;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public String getConcepto() {
			return concepto;
		}
		public void setConcepto(String concepto) {
			this.concepto = concepto;
		}
		public int getNumeroFactura() {
			return numeroFactura;
		}

	}
	
	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	
	public void addConcepto(int cantida, double precio, String concepto) {
		lineas.add(new Linea(cantida, precio, concepto));
	}

	
}
