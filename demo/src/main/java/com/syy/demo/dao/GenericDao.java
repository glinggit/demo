package com.syy.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	T getById(PK id);  
	  
    List<T> findAll();  
  
    PK save(T entity);  
}
