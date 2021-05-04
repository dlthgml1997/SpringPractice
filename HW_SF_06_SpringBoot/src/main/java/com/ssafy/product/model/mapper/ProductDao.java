package com.ssafy.product.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.Product;

public interface ProductDao {
	// CRUD

	List<Product> selectAll() throws SQLException;

	Product select(String id) throws SQLException;

	int insert(Product product) throws SQLException;

	int update(Product product) throws SQLException;

	int delete(String id) throws SQLException;
}
