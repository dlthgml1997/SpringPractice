package com.ssafy.product.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;
import com.ssafy.product.model.service.ProductServiceImpl;

public class BeanTest {
	public static void main(String[] args) throws Exception {
		// 설정 파일에 설정한 bean을 Container가 제공하는 주입기 역할의 api를 통해 주입받는다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sohee/configuration/applicationContext.xml");
		
		ProductService productService = context.getBean("pService", ProductServiceImpl.class);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Product product = new Product();
		System.out.print("상품 번호: ");
		product.setId(in.readLine());
		System.out.print("상품명: ");
		product.setName(in.readLine());
		System.out.print("가격(숫자만 입력): ");
		product.setPrice(Integer.parseInt(in.readLine()));
		System.out.print("설명: ");
		product.setDescription(in.readLine());
		
		try {
			productService.insert(product);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("================================== 상품목록 ================================== ");
		System.out.println("상품번호\t상품명\t가격\t\t\t설명");
		System.out.println("----------------------------------------------------------------");
		
		try {
			List<Product> list = productService.selectAll();
			for(Product p: list) {
				System.out.println(p);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
