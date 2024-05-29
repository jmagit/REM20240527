package com.example.juegos;

/**
 * Excepciones propias de las reglas de los juegos
 * 
 * @author Javier
 */
public class JuegoException extends Exception {

    public JuegoException(String message) {
        super(message);
    }

    public JuegoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
