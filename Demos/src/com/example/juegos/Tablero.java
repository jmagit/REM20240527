package com.example.juegos;

import java.util.Optional;

public class Tablero implements Cloneable {
	private Pieza[][] escaques = new Pieza[8][8];
	
	public Optional<Pieza> getEscaque(int fila, int colunm) {
		return Optional.ofNullable(escaques[fila -1][colunm-1]);
	}

	public void add(int fila, int colunm, Pieza pieza) {
		if(pieza == null) throw new IllegalArgumentException("La pieza es obligatoria");
		
	}
	
	@Override
	public Object clone() {
		var copia = new Tablero();
		// copia.escaques = escaques.clone();
		for (int i = 0; i < escaques.length; i++) {
			copia.escaques[i] = escaques[i].clone();
		}
		return copia;
	}
}
