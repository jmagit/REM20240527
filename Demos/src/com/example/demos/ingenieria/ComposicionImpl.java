package com.example.demos.ingenieria;

import java.util.ArrayList;
import java.util.List;

public abstract class ComposicionImpl extends PiezaImp implements Composicion {
	private List<Pieza> contenido = new ArrayList<>();

	@Override
	public List<Pieza> getContenido() {
		return contenido.stream().toList();
	}

	@Override
	public Composicion addChild(Pieza item) {
		contenido.add(item);
		if(item.getContenedor() != null)
			item.getContenedor().removeChild(item);
		item.setContenedor(this);
		return this;
	}
	
	@Override
	public void removeChild(Pieza item) {
		contenido.remove(item);
	}
	@Override
	public List<Pieza> getChilds() {
		return contenido.stream().toList();
	}
	@Override
	public double getPeso() {
		return contenido.stream().mapToDouble(item -> item.getPeso()).sum();
	}
}
