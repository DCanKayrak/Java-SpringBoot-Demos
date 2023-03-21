package com.dcankayrak.nortwind.entities.dtos;


public class ProductWithCategoryDto {
	private int id;
	private String productName;
	private String category;
	public ProductWithCategoryDto() {
	}
	public ProductWithCategoryDto(int id, String productName, String category) {
		this.id = id;
		this.productName = productName;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return category;
	}
	public void setCategoryName(String categoryName) {
		this.category = categoryName;
	}
}
