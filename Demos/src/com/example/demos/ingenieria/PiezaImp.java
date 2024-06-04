package com.example.demos.ingenieria;

public abstract class PiezaImp implements Pieza {
	private Composicion contenedor;
	
	@Override
	public Composicion getContenedor() {
		return contenedor;
	}

	@Override
	public void setContenedor(Composicion contenedor) {
		this.contenedor = contenedor;
	}

}
