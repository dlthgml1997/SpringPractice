package com.sohee.model.service;

import java.util.List;

import com.sohee.model.dto.Product;
import com.sohee.model.repository.ProductRepo;

public class ProductServiceImpl implements ProductService{
	
	private ProductRepo productRepo;
	
	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> selectAll() throws Exception{
		return productRepo.selectAll();
	}

	@Override
	public Product select(String id) throws Exception{
		return productRepo.select(id);
	}

	// 상품 등록
	@Override
	public int insert(Product product) throws Exception{
		if(product.getName() == null || product.getPrice() == null) {
			throw new Exception();
		}
		return productRepo.insert(product);
	}

	@Override
	public int update(Product product) throws Exception{
		return productRepo.update(product);
	}

	@Override
	public int delete(String id) throws Exception{
		return productRepo.delete(id);
	}

}
