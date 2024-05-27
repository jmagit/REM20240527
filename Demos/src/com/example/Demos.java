package com.example;

import com.example.juegos.Color;
import com.example.juegos.ajedrez.AjedrezJuego;
import com.example.juegos.ajedrez.Rey;

public class Demos {
	
	public static void main(String[] args) {
		var juego = new AjedrezJuego();
		//juego.tablero.add(new Rey(Color.NEGRA));
		var t = juego.getTablero();
		t.add(4,4,new Rey(Color.NEGRA));
		if(t.getEscaque(0, 0).get().getColor() == Color.NEGRA) {
			
		}

	}
}
