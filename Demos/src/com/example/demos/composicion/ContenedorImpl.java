package com.example.demos.composicion;

import java.util.ArrayList;
import java.util.List;

public class ContenedorImpl implements Contenedor {
	private List<Componente> contenido = new ArrayList<>();
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
		System.out.println(toString());
		contenido.forEach(Componente::pintate);
	}

	@Override
	public void addChild(Componente item) {
		contenido.add(item);
		if(item.getContenedor() != null)
			item.getContenedor().removeChild(item);
		item.setContenedor(this);
	}
	
	@Override
	public void removeChild(Componente item) {
		contenido.remove(item);
	}
	@Override
	public List<Componente> getChilds() {
		return contenido.stream().toList();
	}
	
	
}
