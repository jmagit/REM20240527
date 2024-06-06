package com.example.domains.entities;

import java.util.ArrayList;
import java.util.List;

public class Factura {
	public static enum Estado {
		PENDIENTE, CANCELADA, PAGADA
	}
	
	private int numeroFactura;
	private Cliente cliente;
	
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
		public double getTotal() {
			return cantida * precio;
		}
		public int getNumeroFactura() {
			return numeroFactura;
		}
		
		@Override
		protected Linea clone() {
			return new Linea(cantida, precio, concepto);
		}

	}
	
	
	public Factura(int numeroFactura, Cliente cliente) {
		setNumeroFactura(numeroFactura); 
		this.cliente = cliente;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		if(numeroFactura <= 0)
			throw new IllegalArgumentException("El numero fe factura debe ser mayor que 0.");
		this.numeroFactura = numeroFactura;
	}
	
	public void addConcepto(int cantida, double precio, String concepto) {
		lineas.add(new Linea(cantida, precio, concepto));
	}

	public void loadLineas() {
		setLineas(List.of(new Linea(1, 10, "uno"), new Linea(2, 5, "dos")));
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas.stream().map(item -> item.clone()).toList();
	}
	
	public List<Linea> getLineas() {
		return lineas.stream().map(item -> item.clone()).toList();
	}
	public double getTotal() {
		return getLineas().stream().mapToDouble(item -> item.getTotal()).sum();
	}
	
	
}
