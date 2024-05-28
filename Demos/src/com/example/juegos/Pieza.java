package com.example.juegos;

public abstract class Pieza {
	private final Color color;

	public Pieza(Color color) {
		this.color = color;
	}
	
	public Color getColor() { return color; }
	
	protected abstract void ValidaMovimiento(String jugada);
}
