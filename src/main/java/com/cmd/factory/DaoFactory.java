package com.cmd.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.cmd.dao.GenericDao;

public class DaoFactory {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Produces 
	public GenericDao create(InjectionPoint injectionPoint) { 
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0]; 
		return new GenericDao(classe); 
	}
}
