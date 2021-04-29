package com.ssafy.product.model.mapper;

import java.util.List;

import com.ssafy.product.model.dto.Product;

public interface ProductDao {
	List<Product> selectAll() throws Exception;
	Product select(String id) throws Exception;
	int insert(Product product) throws Exception;
	int update(Product product) throws Exception;
	int delete(String id) throws Exception;
}
