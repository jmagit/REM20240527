package com.example.demos.composicion;

public class ContenedorPersistenteImpl extends ContenedorDecorator implements ContenedorPersistente {

	public ContenedorPersistenteImpl(Contenedor contenedor) {
		super(contenedor);
	}

	@Override
	public void cargar() {
		System.err.println("Lo he leido");
		// setOriginal(getOriginal());
	}

	@Override
	public void guardar() {
		System.err.println("Lo he guardado");
	}

}
