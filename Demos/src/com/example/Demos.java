package com.example;

import java.util.Optional;

public class Demos {
	enum Color { BLANCA, NEGRA }
	
	public static abstract class Pieza {
		private final Color color;

		public Pieza(Color color) {
			this.color = color;
		}
		
		public Color getColor() { return color; }
	}
	
	public static class Rey extends Pieza {

		public Rey(Color color) {
			super(color);
		}
		
	}
	public static class Tablero implements Cloneable {
		private Pieza[][] escaques = new Pieza[8][8];
		public void add(Pieza pieza) {
			if(pieza == null) throw new IllegalArgumentException("La pieza es obligatoria");
			
		}
		
		public Optional<Pieza> getEscaque(int fila, int colunm) {
			return Optional.ofNullable(escaques[fila -1][colunm-1]);
		}
		
		@Override
		protected Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				return null;
			}
		}
	}
	
	public static class Ajedrez {
		private Tablero tablero = new Tablero();
		
		public Tablero getTablero() {
			return (Tablero) tablero.clone();
		}
		
		public Ajedrez() {
			inicializar();
		}
		
		public void inicializar() {
			tablero.add(new Rey(Color.NEGRA));
			tablero.add(new Rey(Color.BLANCA));
		}
		
	}
	public static void main(String[] args) {
		var juego = new Ajedrez();
		//juego.tablero.add(new Rey(Color.NEGRA));
		var t = juego.getTablero();
		t.add(new Rey(Color.NEGRA));
		if(t.getEscaque(0, 0).get().getColor() == Color.NEGRA) {
			
		}

	}

}
