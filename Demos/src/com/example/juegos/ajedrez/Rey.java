package com.example.juegos.ajedrez;

import com.example.juegos.Color;
import com.example.juegos.Pieza;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	@Override
	protected void ValidaMovimiento(String jugada) {
		throw new NoClassDefFoundError();
	}
	
}
