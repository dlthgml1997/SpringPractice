package com.ssafy.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Product : 상품정보", description = "상품의 아이디, 이름, 가격, 상세정보 등을 설정합니다.")
public class Product {
	
	@ApiModelProperty(value="상품 아이디")
	String id;
	@ApiModelProperty(value="상품 이름")
	String name;
	@ApiModelProperty(value="상품 가격")
	Integer price;
	@ApiModelProperty(value="상품 설명")
	String description;
	
	public Product() {
		super();
	}
	
	public Product(String id, String name, Integer price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
	
}
