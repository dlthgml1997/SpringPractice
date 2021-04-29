package com.ssafy.product.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// 호출 되기 전 * :어떤 리턴타입이던, ..: depth 상관없이 *: 클래스 상관없이 *: 메소드 상관없이 
	@Before(value = "execution(* com.ssafy.guestbook.model..*.*(..))")
	public void loggin(JoinPoint jp) {
		logger.debug("메서드 선언부 : {} 전달 파라미터 : {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
	
}
