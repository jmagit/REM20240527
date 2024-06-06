package com.example.domains.services;

import java.util.List;

import com.example.domains.contracts.Repository;
import com.example.domains.contracts.Service;

public abstract class ServiceImpl<E, K> implements Service<E, K> {
	private Repository<E, K> repository;

	public ServiceImpl(Repository<E, K> repository) {
		this.repository = repository;
	}

	@Override
	public List<E> getAll() {
		// ... Reglas de negocio
		return repository.getAll();
	}

	@Override
	public E getById(K id) {
		// ... Reglas de negocio
		return repository.getById(id);
	}

	@Override
	public void add(E item) {
		// ... Reglas de negocio
		// Valida datos
		if (repository.getBy(item) != null) {
			// Excepción
		}
		repository.add(item);
	}

	@Override
	public void modify(E item) {
		// ... Reglas de negocio
		if (repository.getBy(item) == null) {
			// Excepción
		}
		repository.modify(item);

	}

	@Override
	public void remove(E item) {
		// ... Reglas de negocio
		repository.remove(item);
	}

	@Override
	public void removeById(K id) {
		// ... Reglas de negocio
		repository.removeById(id);

	}

}
