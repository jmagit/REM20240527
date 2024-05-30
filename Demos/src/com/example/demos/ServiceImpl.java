package com.example.demos;

import java.util.List;

public abstract class ServiceImpl<E, K> implements Service<E, K> {
	private Repository<E, K> repository;

	protected abstract Repository<E, K> createRepository();

	public ServiceImpl(Repository<E, K> repository) {
		super();
		this.repository = repository;
	}
//	public ServiceImpl() {
//		super();
//		this.repository = createRepository();
//	}

	@Override
	public List<E> getAll() {
		repository = createRepository();
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
		repository = createRepository();
		// ... Reglas de negocio
		// Valida datos
		if (repository.getBy(item) != null) {
			// Excepción
		}
		repository.add(item);
	}

	@Override
	public void modify(E item) {
		repository = createRepository();
		// ... Reglas de negocio
		if (repository.getBy(item) == null) {
			// Excepción
		}
		repository.modify(item);

	}

	@Override
	public void remove(E item) {
		repository = createRepository();
		// ... Reglas de negocio
		repository.remove(item);
	}

	@Override
	public void removeById(K id) {
		repository = createRepository();
		// ... Reglas de negocio
		repository.removeById(id);

	}

}
