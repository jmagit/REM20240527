package com.example.juegos.ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.juegos.Color;
import com.example.juegos.JuegoException;
import com.example.juegos.Movimiento;
import com.example.juegos.Tablero;

class AjedrezJuegoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testInicializar() {
		var j = new AjedrezJuego();
		assertAll("Inicializa", 
				() -> assertEquals(Color.BLANCO, j.getTurno()), 
				() -> assertEquals(0, j.getJugada()),
				() -> assertNotSame(j.getTablero(), j.getResultado()),
				() -> assertTrue(j.getTablero().equals(j.getResultado())),
				() -> assertFalse(j.getFinalizado())
			);
	}

	@Test
	void testJugada() throws JuegoException {
		var j = new AjedrezJuego();
		j.jugada("E2E4"); assertEquals(Color.NEGRO, j.getTurno());
		j.jugada("E7E5"); assertEquals(Color.BLANCO, j.getTurno());
		j.jugada("F1C4"); assertEquals(Color.NEGRO, j.getTurno());
		j.jugada("B8C6"); assertEquals(Color.BLANCO, j.getTurno());
		j.jugada("D1H5"); assertEquals(Color.NEGRO, j.getTurno());
		j.jugada("FIN"); // Jaque mate
		assertTrue(j.getFinalizado());
	}

	@Test
	void testSinPiezaInicial() throws JuegoException {
		var j = new AjedrezJuego();
		assertThrows(JuegoException.class, () -> j.jugada("D4D5"));
	}

	@Test
	void testComerPropia() throws JuegoException {
		var j = new AjedrezJuego();
		assertThrows(JuegoException.class, () -> j.jugada("A1A2"));
	}

	@Test
	void testMoverContraria() throws JuegoException {
		var j = new AjedrezJuego();
		assertThrows(JuegoException.class, () -> j.jugada("E7E5"));
	}


	@Test
	void testFinalizar() throws JuegoException {
		var j = new AjedrezJuego();
		
		j.jugada("tablas"); 
		assertTrue(j.getFinalizado());
		assertThrows(JuegoException.class, () -> j.jugada("E7E5"));
	}
	@Test
	void testPromocion() throws JuegoException {
		var j = new AjedrezJuego();
		var tablero = new Tablero();
		var pieza = new Torre(Color.BLANCO);		
		var peon = new Peon(Color.BLANCO);
		tablero.setPieza(7,  2, peon);
		
		j.continuar(tablero, Color.BLANCO);
		j.addPromocionaListener(arg -> { arg.setPieza(pieza); });
		
		j.jugada("B7B8");
		
		assertFalse(j.getTablero().hayPieza(7, 2));
		assertSame(pieza, j.getTablero().getPieza(8, 2));
	}

}
