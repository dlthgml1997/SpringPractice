package com.sohee.model.repository;

import java.util.List;

import com.sohee.model.dto.Product;

public interface ProductRepo {
	List<Product> selectAll() throws Exception;
	Product select(String id) throws Exception;
	int insert(Product product) throws Exception;
	int update(Product product) throws Exception;
	int delete(String id) throws Exception;
}
