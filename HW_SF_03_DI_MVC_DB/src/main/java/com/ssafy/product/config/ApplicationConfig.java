package com.ssafy.product.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 이 파일이 환경설정 파일임을 명시한다.
@Configuration
// basePackage를 통해 빈을 스캔한다.
@ComponentScan(basePackages = {"com.ssafy.product"})
// AOP의 Proxy 생성을 설정한다.
@EnableAspectJAutoProxy

public class ApplicationConfig {

	/**
	 * Annotation 방식으로 생성할 수 없는 빈은 @Bean을 통해 선언한다.
	 * @return
	 */
	@Bean
	public DataSource datasource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		return ds;
	}
}
