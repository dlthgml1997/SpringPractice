package com.ssafy.product.interceptor;

import javax.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.product.model.Product;


@Component
public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Product product = (Product) session.getAttribute("userinfo");
		if(product == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
	}
}
