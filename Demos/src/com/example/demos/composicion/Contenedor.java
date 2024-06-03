package com.example.demos.composicion;

import java.util.List;

public interface Contenedor extends Componente {
	void addChild(Componente item);
	void removeChild(Componente item);
	List<Componente> getChilds();
}
