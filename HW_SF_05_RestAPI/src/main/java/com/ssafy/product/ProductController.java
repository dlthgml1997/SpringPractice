package com.ssafy.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
//	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	@GetMapping("/regist")
	public String regist() {
		return "product/regist";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		try {
			List<Product> list = productService.selectAll();
			model.addAttribute("products", list);
			return "product/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/controll")
	public String Mvcontroll() {
		return "product/controll";
	}
}
