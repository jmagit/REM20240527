package com.example.juegos.ajedrez;

import com.example.juegos.Color;
import com.example.juegos.Tablero;

public class AjedrezJuego {
	private Tablero tablero;
	private Color turno;

	public AjedrezJuego() {
		inicializar();
	}

	public Tablero getTablero() {
		return (Tablero) tablero.clone();
	}

	public Color getTurno() {
		return turno;
	}

	public void inicializar() {
		turno = Color.BLANCA;
		tablero = new Tablero();
		tablero.add(1, 5, new Rey(Color.BLANCA));
		tablero.add(8, 5, new Rey(Color.NEGRA));
	}

	public void jugar(String jugada) {
		// ...
		cambiaTurno();
	}

	protected void cambiaTurno() {
		turno = turno == Color.BLANCA ? Color.NEGRA : Color.BLANCA;
	}
}
