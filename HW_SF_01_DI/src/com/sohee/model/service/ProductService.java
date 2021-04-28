package com.sohee.model.service;

import java.util.List;

import com.sohee.model.dto.Product;
import com.sohee.model.repository.ProductRepo;

public interface ProductService {
	
	void setProductRepo(ProductRepo productRepo);
	ProductRepo getProductRepo();
	List<Product> selectAll() throws Exception;
	Product select(String id) throws Exception;
	int insert(Product product) throws Exception;
	int update(Product product) throws Exception;
	int delete(String id) throws Exception;
}
