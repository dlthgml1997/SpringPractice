package com.ssafy.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.Product;
import com.ssafy.product.model.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("상품 컨트롤러 API V1")
@CrossOrigin("*")
@RequestMapping("/rest")
public class ProductRestController {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "상품목록", notes = "상품의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "상품목록OK"),
		@ApiResponse(code = 404, message = "페이지없어!!"),
		@ApiResponse(code = 500, message = "서버에러!!")
	})
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

	@ApiOperation(value = "상품정보조회", notes = "id에 해당하는 상품을 조회.")
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
	
	@ApiOperation(value = "상품추가", notes = "상품 정보를 받아서 DB에 저장.")
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

	@ApiOperation(value = "상품수정", notes = "상품의 정보를 수정합니다. (ID는 수정 불가)")
	@PutMapping("/update")
	public int update(@RequestBody Product product) {
		logger.info("update()");
		System.out.println(product.toString());
		int result = 0;
		try {
			result = productService.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@ApiOperation(value = "상품삭제", notes= "id에 해당하는 상품 정보를 삭제합니다.")
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
