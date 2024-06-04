package com.example.demos.composicion;

import java.util.List;

public abstract class ContenedorDecorator implements Contenedor {
	private Contenedor original;

	
	protected Contenedor getOriginal() {
		return original;
	}

	protected void setOriginal(Contenedor original) {
		if(original == null)
			throw new IllegalArgumentException("Es obligatorio el original");
		this.original = original;
	}

	public ContenedorDecorator(Contenedor contenedor) {
		if(contenedor == null)
			throw new IllegalArgumentException("Es obligatorio el original");
		this.original = contenedor;
	}

	@Override
	public void pintate() {
		original.pintate();
	}

	@Override
	public Contenedor getContenedor() {
		return original.getContenedor();
	}

	@Override
	public void setContenedor(Contenedor contenedor) {
		contenedor.setContenedor(contenedor);	
	}

	@Override
	public void addChild(Componente item) {
		original.addChild(item);
	}

	@Override
	public void removeChild(Componente item) {
		original.removeChild(item);
	}

	@Override
	public List<Componente> getChilds() {
		return original.getChilds();
	}

}
