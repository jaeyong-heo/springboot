package com.api.springboot.dto;

public class ProductResponseDTO {

	private Long number;
	private String name;
	private int price;
	private int stock;
	
	
	public ProductResponseDTO() {}

	public ProductResponseDTO(Long number, String name, int price, int stock) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
