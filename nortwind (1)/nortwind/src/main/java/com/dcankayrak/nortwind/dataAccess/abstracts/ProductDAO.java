package com.dcankayrak.nortwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcankayrak.nortwind.entities.concretes.Product;
import com.dcankayrak.nortwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDAO extends JpaRepository<Product,Integer>{
	
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory(String productName,int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query(value = "From Product where productName =:productName and category.categoryId=:categoryId")
	List<Product> GetByProductAndCategory(String productName,int categoryId);
	
	@Query(value = "Select new com.dcankayrak.nortwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id,p.productName,p.category) From "
			+ "Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
