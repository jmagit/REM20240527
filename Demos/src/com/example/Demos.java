package com.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.example.juegos.Color;
import com.example.juegos.JuegoException;
import com.example.juegos.Pieza;
import com.example.juegos.Tablero;
import com.example.juegos.ajedrez.AjedrezJuego;
import com.example.juegos.ajedrez.Alfil;
import com.example.juegos.ajedrez.Caballo;
import com.example.juegos.ajedrez.Dama;
import com.example.juegos.ajedrez.PromocionEvent;
import com.example.juegos.ajedrez.Torre;

public class Demos {
	
	public static void main(String[] args) throws JuegoException {
		var app = new Demos();
		app.ajedrez();

	}

	private static final Scanner teclado = new Scanner(System.in);
	private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

	public void ajedrez() {
		var juego = new AjedrezJuego();
		juego.inicializar();
		juego.addPromocionaListener(this::pidePieza);
		do {
			try {
				pintaTablero(juego.getResultado());
				System.out.print("Juegan las " + (juego.getTurno() == Color.BLANCO ? "blancas" : "negras")
						+ ". Dame jugada [CFCF]: ");
				juego.jugada(teclado.nextLine().toUpperCase());
			} catch (JuegoException e) {
				System.out.println(e.getMessage());
			}
		} while (!juego.getFinalizado());
		System.out.println("Juego Finalizado");
	}

	private void pintaTablero(Tablero t) {
		for (int f = 8; f > 0; f--) {
			System.out.print(String.format("%2s ", f));
			for (int c = 1; c <= 8; c++) {
				if (t.hayPieza(f, c))
					System.out.print(String.format("%10s ", t.getPieza(f, c)));
				else
					System.out.print(Tablero.colorEscaque(f, c) == Color.BLANCO ? "            " : "-----------");
			}
			System.out.println();
		}
		for (char c = 'A'; c <= 'H'; c++) {
			System.out.print(String.format("%8c    ", c));
		}
		System.out.println();
	}
	
	private void pidePieza(PromocionEvent e) {
		System.out.print("\t1: Dama\n\t2: Alfil\n\t3: Torre\n\t4: Caballo\n\t5: Cancelar\n"
				+ "Dame la opción para promocionar el peón " + (e.getColor() == Color.BLANCO ? "blanco: " : "negro:"));
		switch (Integer.parseInt(teclado.nextLine())) {
		case 1:
			e.setPieza(new Dama(e.getColor())); break;
		case 2:
			e.setPieza(new Alfil(e.getColor())); break;
		case 3:
			e.setPieza(new Torre(e.getColor())); break;
		case 4:
			e.setPieza(new Caballo(e.getColor())); break;
		case 5:
			e.setCancel(true); break;
		default:
			e.setPieza(null); break;
		}
	}

}
