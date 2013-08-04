package org.sharkness.dbunit.service.impl;

import java.io.Serializable;
import java.util.List;

import org.sharkness.dbunit.dao.interfaces.GenericDAO;
import org.sharkness.dbunit.service.interfaces.GenericService;

public class GenericImplService<T, DAO extends GenericDAO<T>> implements GenericService<T> {

	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public T get(Serializable id) {
		return dao.get(id);
	}

	@Override
	public List<T> list() {
		return dao.list();
	}
	
}
