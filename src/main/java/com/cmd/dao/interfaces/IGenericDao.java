package com.cmd.dao.interfaces;

import java.util.List;

public interface IGenericDao<T> {
	public void save(T object);
	public void update(T object);
	public void saveOrUpdate(T object);
	public void delete(T object);
	public List<T> listAll();
	public List<T> selectOneMenu();
	public T select(T object);
	public T selectById(Object id);
}
