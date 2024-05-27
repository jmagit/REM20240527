package com.example.juegos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Pruebas unitarias: Clase Posicion")
class PosicionTest {

	@ParameterizedTest(name = "Posición => ({0}, {1})")
	@CsvSource(value = {"1,8","8,1"})
	@DisplayName("Constructor con enteros: casos validos")
	void testPosicionIntValida(int fila, int columna) throws JuegoException {
		var posicion = new Posicion(fila, columna);
		assertNotNull(posicion);
		assertAll("Posicion", 
				() -> assertEquals(fila, posicion.getFila(), "fila"),
				() -> assertEquals(columna, posicion.getColumna(), "columna")
				);
	}
	@ParameterizedTest(name = "Posición => ({0}, {1})")
	@CsvSource(value = {"0,8","9,1","1,0","8,9"})
	@DisplayName("Constructor con enteros: casos invalidos")
	void testPosicionIntInvalida(int fila, int columna) throws JuegoException {
		assertThrows(JuegoException.class, () -> new Posicion(fila, columna));
	}
	@ParameterizedTest(name = "Posición => (''{0}'', ''{1}'')")
	@CsvSource(value = {"1,A,1,1","8,H,8,8"})
	@DisplayName("Constructor con letras: casos validos")
	void testPosicionCharValida(char fila, char columna, int filaRslt, int columnaRslt) throws JuegoException {
		var posicion = new Posicion(fila, columna);
		assertNotNull(posicion);
		assertAll("Posicion", 
				() -> assertEquals(filaRslt, posicion.getFila(), "fila"),
				() -> assertEquals(columnaRslt, posicion.getColumna(), "columna")
				);
	}
	@ParameterizedTest(name = "Posición => (''{0}'', ''{1}'')")
	@CsvSource(value = {"0,A","9,H","1,a","8,M","2, ' '"})
	@DisplayName("Constructor con letras: casos validos")
	void testPosicionCharInvalida(char fila, char columna) throws JuegoException {
		assertThrows(JuegoException.class, () -> new Posicion(fila, columna));
	}


}
