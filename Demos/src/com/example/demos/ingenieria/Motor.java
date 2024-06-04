package com.example.demos.ingenieria;

import java.util.Optional;

public class Motor extends ComposicionImpl {
	public static Motor getNew() {
		return new Motor();
	}

	public Optional<Carter> getCarter() {
		return getChilds().stream()
				.filter(item -> item instanceof Carter)
				.map(item -> (Carter)item)
				.findFirst();
	}

	public Optional<Culata> getCulata() {
		return getChilds().stream()
				.filter(item -> item instanceof Culata)
				.map(item -> (Culata)item)
				.findFirst();
	}
	
//	public static Builder getBuilder() {
//		return new Builder();
//	}
//	
//	public interface AddBuilder {
//		AddBuilder addTelefono(String telefono);
//		AddBuilder addCorreo(String correo);
//		AddBuilder addDireccion(String direccion);
//		Cliente build();
//	}
//	public static class Builder implements AddBuilder {
//		Cliente cliente = new Cliente();
//		boolean created = false;
//		
//		public AddBuilder nombre(String nombre, String apellidos) {
//			if(nombre == null || nombre.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta el nombre");
//			if(apellidos == null || apellidos.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta los apellidos");
//			cliente.tipo = Tipo.PERSONA_FISICA;
//			cliente.nombre = nombre;
//			cliente.apellidos = apellidos;
//			return this;
//		}
//		public AddBuilder razonSocial(String razonSocial) {
//			if(razonSocial == null || razonSocial.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta la razon social");
//			cliente.tipo = Tipo.PERSONA_JURIDICA;
//			cliente.nombre = razonSocial;
//			cliente.apellidos = null;
//			return this;
//		}
//
//		@Override
//		public AddBuilder addTelefono(String telefono) {
//			if(telefono == null || telefono.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta el teléfono");
//			cliente.telefonos.add(telefono);
//			return this;
//		}
//
//		@Override
//		public AddBuilder addCorreo(String correo) {
//			if(correo == null || correo.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta el correo");
//			cliente.correos.add(correo);
//			return this;
//		}
//
//		@Override
//		public AddBuilder addDireccion(String direccion) {
//			if(direccion == null || direccion.trim().isEmpty()) 
//				throw new IllegalArgumentException("Falta la dirección");
//			cliente.direcciones.add(direccion);
//			return this;
//		}
//		
//		@Override
//		public Cliente build() {
//			if(created) 
//				throw new IllegalArgumentException("Ya esta creado");
//			if(cliente.nombre == null)
//				throw new IllegalArgumentException("Falta " + (cliente.tipo == Tipo.PERSONA_FISICA ? "el nombre y los apellidos" : "la razón social"));
//			if(cliente.telefonos.size() == 0 && cliente.correos.size() == 0 && cliente.direcciones.size() == 0)
//				throw new IllegalArgumentException("Debe tener un teléfono, dirección o correo elcetrónico");
//			created = true;
//			return cliente;
//		}
//	}
}
