package com.example.demos.composicion;

public class ContenedorLoggerImpl extends ContenedorDecorator implements ContenedorLogger {

	public ContenedorLoggerImpl(Contenedor contenedor) {
		super(contenedor);	}

	@Override
	public void addChild(Componente item) {
		System.err.println("add " + item.toString());
		super.addChild(item);
	}

	@Override
	public void removeChild(Componente item) {
		System.err.println("remove " + item.toString());
		super.addChild(item);
	}
}
