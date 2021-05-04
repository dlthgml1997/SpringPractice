package com.ssafy.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.mapper.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Product> selectAll() throws Exception{
		return sqlSession.getMapper(ProductDao.class).selectAll();
	}

	@Override
	public Product select(String id) throws Exception{
		return sqlSession.getMapper(ProductDao.class).select(id);
	}

	@Override
	public int insert(Product product) throws Exception{
		if(product.getName() == null || product.getPrice() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(ProductDao.class).insert(product);
	}

	@Override
	public int update(Product product) throws Exception{
		return  sqlSession.getMapper(ProductDao.class).update(product);
	}

	@Transactional
	@Override
	public int delete(String id) throws Exception{
		return sqlSession.getMapper(ProductDao.class).delete(id);
	}

}
