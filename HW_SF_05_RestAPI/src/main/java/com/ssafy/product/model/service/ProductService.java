package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Product;

public interface ProductService {
	
//	void setProductRepo(ProductRepo productRepo);
//	ProductRepo getProductRepo();
	List<Product> selectAll() throws Exception;
	Product select(String id) throws Exception;
	int insert(Product product) throws Exception;
	int update(Product product) throws Exception;
	int delete(String id) throws Exception;
}
