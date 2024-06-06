package com.example.domains.contracts;

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

	E getById(K id);

	E getBy(E item);

	void add(E item);

	void modify(E item);

	void remove(E item);

	void removeById(K id);

}