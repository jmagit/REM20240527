package com.example.demos.ingenieria;

public abstract class Tornillo extends PiezaImp {
	private final double peso;
	
	public Tornillo(double peso) {
		if(peso <= 0)
			throw new IllegalArgumentException("El peso debe ser mallor que 0");
		this.peso = peso;
	}

	@Override
	public double getPeso() {
		return peso;
	}
	
	public double getLongitud() {
		return peso;
	}
}
