package com.example.demos.ingenieria;

import java.util.List;

public interface Composicion extends Pieza {
	List<Pieza> getContenido();
	Composicion addChild(Pieza item);
	void removeChild(Pieza item);
	List<Pieza> getChilds();
}
