package com.ssafy.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

@RestController
public class ProductRestController {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Product> selectAll() {
		logger.info("selectAll()");
		List<Product> list = new ArrayList<>();
		try {
			list = productService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public Product select(@PathVariable("id") String id) {
		logger.info("select()");
		Product product = new Product();
		try {
			product = productService.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@PostMapping("/insert")
	public ResponseEntity<Product> insert(Product product) {
		logger.info("insert()");
		int result = 0;
		try {
			result = productService.insert(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/update")
	public int update(@RequestBody Product product) {
		logger.info("update()");
		System.out.println(product.toString());
//		product = new Product("004","수박",1000,"맛있어");
		int result = 0;
		try {
			result = productService.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		logger.info("delete()");
		int result = 0;
		try {
			result = productService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0)
			return new ResponseEntity<String>(HttpStatus.OK);
		else
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
