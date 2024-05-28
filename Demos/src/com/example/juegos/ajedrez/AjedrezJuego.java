package com.example.juegos.ajedrez;

import com.example.juegos.Color;
import com.example.juegos.JuegoException;
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

	public void jugar(String jugada) throws JuegoException {
//		assert jugada != null;
		if (jugada == null)
			throw new IllegalArgumentException("Falta la jugada");
		// ...
		try {

		} catch (Exception e) {
			throw new JuegoException("No controlada", e);
		}
		cambiaTurno();
	}

	protected void cambiaTurno() {
		turno = turno == Color.BLANCA ? Color.NEGRA : Color.BLANCA;
	}
}
