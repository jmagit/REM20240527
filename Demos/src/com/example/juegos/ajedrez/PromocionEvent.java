package com.example.juegos.ajedrez;

import java.util.EventObject;
import com.example.juegos.Color;
import com.example.juegos.Pieza;

/**
 * Argumentos de acompañamiento de la promoción del evento.
 * @author Javier
 * @version 1.0
 */
public class PromocionEvent extends EventObject {

	private Color color;
	private boolean cancel;
	private Pieza pieza;
	
	/**
	 * Constructor único
	 * @param color Color del Peón.
	 */
	public PromocionEvent(Object source, Color color) {
		super(source);
		this.color = color;
		cancel = false;
	}

	/**
	 * Color para hacer la petición en la promoción
	 * @return Color del Peón.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Indica al peón que debe cancelar la promoción
	 * @return true para cancelar, false por defecto
	 */
	public boolean isCancel() {
		return cancel;
	}

	/**
	 * Permite establecer desde el delegado que se debe cancelar la promoción
	 * @param cancel true para cancelar, false por defecto
	 */
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	/**
	 * Recupera la pieza seleccionada
	 * @return La pieza para la promoción
	 */
	public Pieza getPieza() {
		return pieza;
	}

	/**
	 * Establece la pieza que sustituye al peón
	 * @param pieza Pieza para la promoción
	 */
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	

}
