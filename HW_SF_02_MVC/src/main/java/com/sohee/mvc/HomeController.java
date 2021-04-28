package com.sohee.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sohee.mvc.model.Calculator;
import com.sohee.mvc.model.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@GetMapping("/HW_SF_02/0427/hello")
	public String hello() {
		return "0427/hello";
	}
	
	@RequestMapping(value = "/input", method=RequestMethod.GET)
	public String input() {
		return "0427/input";
	}
	
	@GetMapping("/result")
	public String result(@RequestParam String name) {
//		logger.trace("입력된 이름: "+name);	
		System.out.println("입력된 이름: "+ name);
		return "home";
	}
	
	@GetMapping("/inputgroup")
	public String inputGroup() {
		return "0427/input2";
	}
	
	@GetMapping("/result2")
	public String result2 (UserDto userDto) {
	//(@RequestParam String name, @RequestParam String age, @RequestParam String job) {
		System.out.println("이름: "+ userDto.getName() + " 나이: "+ userDto.getAge() + " 직업: "+ userDto.getJob());
		return "home";
	}
	
	@GetMapping("/calc")
	public String calculate() {
		return "calc";
	}
	
	@GetMapping("/calcresult")
	public ModelAndView calcresult(Calculator calculator) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", calculator.getResult());
		mav.setViewName("calc");
		return mav; 
	}
}
