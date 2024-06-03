package com.example.demos.composicion;

public class Foto  implements Componente {
	private Contenedor contenedor;
	
	@Override
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
	@Override
	public Contenedor getContenedor() {
		return contenedor;
	}

	@Override
	public void pintate() {
		System.out.println("Soy un " + getClass().getSimpleName());
	}
	
}