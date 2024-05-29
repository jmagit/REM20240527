package com.example.demos;

import java.util.List;

/**
 * 
 * @param <E>
 * @param <K>
 */
public interface Repository<E, K> {
/**
 * 
 * @return
 */
	List<E> getAll();

	Factura getById(K id);

	void add(E item);

	void modify(E item);

	void remove(E item);

	void removeById(K id);

}