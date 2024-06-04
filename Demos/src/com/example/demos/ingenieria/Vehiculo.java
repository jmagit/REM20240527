package com.example.demos.ingenieria;

public class Vehiculo {
	private Composicion partes = new ElementoCompuesto();
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public double getPeso() {
		return partes.getPeso();
	}
	
	public void setMotor(Motor motor) {
		if(motor == null)
			throw new IllegalArgumentException("Falta el motor");
		if(partes.getChilds().stream().anyMatch(item -> item instanceof Motor)) 
			throw new IllegalArgumentException("Ya tiene motor");
		partes.addChild(motor);
	}
	public Motor getMotor() {
		return partes.getChilds().stream()
				.filter(item -> item instanceof Motor)
				.map(item -> (Motor)item)
				.findFirst()
				.get();
	}

	// builder

}
