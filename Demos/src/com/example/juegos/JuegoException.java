package com.example.juegos;

/**
 * Excepciones propias de las reglas de los juegos
 * 
 * @author Javier
 */
public class JuegoException extends Exception {
	private static final long serialVersionUID = 1L;

	public JuegoException(String message) {
        super(message);
    }

    public JuegoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
