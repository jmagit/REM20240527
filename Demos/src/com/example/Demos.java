package com.example;

import com.example.juegos.Color;
import com.example.juegos.JuegoException;
import com.example.juegos.ajedrez.AjedrezJuego;
import com.example.juegos.ajedrez.Rey;

public class Demos {
	
	public static void main(String[] args) throws JuegoException {
		var juego = new AjedrezJuego();
		//juego.tablero.add(new Rey(Color.NEGRA));
		var t = juego.getTablero();
		t.add(4,4,new Rey(Color.NEGRA));
		if(t.getEscaque(1, 5).isPresent() && t.getEscaque(1, 5).get().getColor() == Color.NEGRA) {
			
		}
		juego.jugar(null);

	}
}
