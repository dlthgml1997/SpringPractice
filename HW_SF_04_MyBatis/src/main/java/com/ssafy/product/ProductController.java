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
	
	@PostMapping("/insert")
	public String insert(Product product, Model model, HttpSession session) {
//		Member memberDto = (Member) session.getAttribute("userinfo");
//		if(memberDto != null) {
//			logger.debug("로그인 했다면....!!!");
//			product.setUserid(memberDto.getUserid());
			try {
				productService.insert(product);
				return "product/registsuccess";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "상품 등록 중 문제가 발생했습니다.");
				return "error/error";
			}
//		} else {
//			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
//			return "error/error";
//		}
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
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String modify(Product product, Model model) {
		try {
			productService.update(product);
			return "product/updatesuccess";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "수정 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, Model model) {
		try {
			productService.delete(id);
			return "product/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
}
