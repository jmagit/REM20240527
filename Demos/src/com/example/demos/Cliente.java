package com.example.demos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente {
	public static enum Tipo {
		PERSONA_FISICA, PERSONA_JURIDICA
	}
	
	private int id;
	private Tipo tipo;
	private String nombre;
	private String apellidos;
	private Set<String> telefonos = new HashSet<>();
	private Set<String> correos = new HashSet<>();
	private Set<String> direcciones = new HashSet<>();
	
	private Cliente() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getNombre() {
		if(tipo == Tipo.PERSONA_JURIDICA)
			throw new IllegalAccessError("No es una persona física");
		return nombre;
	}

	public void setNombre(String nombre) {
		if(tipo == Tipo.PERSONA_JURIDICA)
			throw new IllegalAccessError("No es una persona física");
		this.nombre = nombre;
	}

	public String getApellidos() {
		if(tipo == Tipo.PERSONA_JURIDICA)
			throw new IllegalAccessError("No es una persona física");
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if(tipo == Tipo.PERSONA_JURIDICA)
			throw new IllegalAccessError("No es una persona física");
		this.apellidos = apellidos;
	}

	public String getRazonSocial() {
		if(tipo == Tipo.PERSONA_FISICA)
			throw new IllegalAccessError("No es una persona juridica");
		return nombre;
	}

	public void setRazonSocial(String razonSocial) {
		if(tipo == Tipo.PERSONA_FISICA)
			throw new IllegalAccessError("No es una persona juridica");
		this.nombre = razonSocial;
	}

	public Set<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<String> telefono) {
		this.telefonos = telefono;
	}

	public Set<String> getCorreos() {
		return correos;
	}

	public void setCorreos(Set<String> correos) {
		this.correos = correos;
	}

	public Set<String> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<String> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	public interface AddBuilder {

		AddBuilder addTelefono(String telefono);

		AddBuilder addCorreo(String correo);

		AddBuilder addDireccion(String direccion);

		Cliente build();

	}
	public static class Builder implements AddBuilder {
		Cliente cliente = new Cliente();
		boolean created = false;
		
		public Builder nombre(String nombre, String apellidos) {
			if(nombre == null || nombre.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta el nombre");
			if(apellidos == null || apellidos.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta los apellidos");
			cliente.tipo = Tipo.PERSONA_FISICA;
			cliente.nombre = nombre;
			cliente.apellidos = apellidos;
			return this;
		}
		public Builder razonSocial(String razonSocial) {
			if(razonSocial == null || razonSocial.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta la razon social");
			cliente.tipo = Tipo.PERSONA_JURIDICA;
			cliente.nombre = razonSocial;
			return this;
		}

		@Override
		public AddBuilder addTelefono(String telefono) {
			if(telefono == null || telefono.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta el teléfono");
			cliente.telefonos.add(telefono);
			return this;
		}

		@Override
		public AddBuilder addCorreo(String correo) {
			if(correo == null || correo.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta el correo");
			cliente.correos.add(correo);
			return this;
		}

		@Override
		public AddBuilder addDireccion(String direccion) {
			if(direccion == null || direccion.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta la dirección");
			cliente.direcciones.add(direccion);
			return this;
		}
		
		@Override
		public Cliente build() {
			if(created) 
				throw new IllegalArgumentException("Ya esta creado");
			if(cliente.nombre == null)
				throw new IllegalArgumentException("Falta " + (cliente.tipo == Tipo.PERSONA_FISICA ? "el nombre y los apellidos" : "la razón social"));
			if(cliente.telefonos.size() == 0 && cliente.correos.size() == 0 && cliente.direcciones.size() == 0)
				throw new IllegalArgumentException("Debe tener un teléfono, dirección o correo elcetrónico");
			created = true;
			return cliente;
		}
		
	}
}
