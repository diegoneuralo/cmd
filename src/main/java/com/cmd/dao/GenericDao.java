package com.cmd.dao;

import java.util.List;

import com.cmd.dao.interfaces.IGenericDao;

public class GenericDao<T> implements IGenericDao<T> {
	
	private Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectOneMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T select(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}