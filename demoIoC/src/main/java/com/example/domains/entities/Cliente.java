package com.example.domains.entities;

import java.util.HashSet;
import java.util.Iterator;
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
		if(razonSocial == null)
			throw new IllegalAccessError("Falta la razonSocial");
		this.nombre = razonSocial;
	}

	public Iterator<String> getTelefonos() {
		return telefonos.iterator();
	}

	public void setTelefonos(Set<String> telefono) {
		this.telefonos = telefono;
	}

	public Iterator<String> getCorreos() {
		return correos.iterator();
	}

	public void setCorreos(Set<String> correos) {
		this.correos = correos;
	}

	public Iterator<String> getDirecciones() {
		return direcciones.iterator();
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
		var sb = new StringBuilder("Cliente [id=" + id + ", tipo=" + tipo + ", ");
		if(tipo == Tipo.PERSONA_FISICA) {
			sb.append("nombre=" + nombre + ", apellidos=" + apellidos);
		} else {
			sb.append("razonSocial=" + nombre);
		}
		sb.append(", telefonos=" + telefonos + ", correos=" + correos + ", direcciones=" + direcciones + "]");
		return sb.toString();
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
		
		public AddBuilder nombre(String nombre, String apellidos) {
			if(nombre == null || nombre.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta el nombre");
			if(apellidos == null || apellidos.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta los apellidos");
			cliente.tipo = Tipo.PERSONA_FISICA;
			cliente.nombre = nombre;
			cliente.apellidos = apellidos;
			return this;
		}
		public AddBuilder razonSocial(String razonSocial) {
			if(razonSocial == null || razonSocial.trim().isEmpty()) 
				throw new IllegalArgumentException("Falta la razon social");
			cliente.tipo = Tipo.PERSONA_JURIDICA;
			cliente.nombre = razonSocial;
			cliente.apellidos = null;
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
