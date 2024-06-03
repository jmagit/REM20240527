package com.example.demos.composicion;


public abstract class Figura implements Componente {
	private Contenedor contenedor;
	
	@Override
	public void pintate() {
		System.out.println("Soy un " + getClass().getSimpleName());
	}
	
	@Override
	public Contenedor getContenedor() {
		return contenedor;
	}

	@Override
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}


}
