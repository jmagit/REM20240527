package com.example.juegos.ajedrez;

import com.example.juegos.Pieza;

/**
 * Permite crear un delegado para solicitar al usuario la pieza para la promoción del peón.
 * @author Javier
 * @version 1.0
 */
@FunctionalInterface
public interface PromocionEventListener {
	/**
	 * Solicitar al usuario la pieza para la promoción del peón.
	 * @param arg Color de la pieza y permitir cancelar la operación.
	 */
	void promociona(PromocionEvent arg);
}
