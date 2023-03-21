package com.dcankayrak.nortwind.business.abstracts;

import java.util.List;

import com.dcankayrak.nortwind.core.utilities.results.DataResult;
import com.dcankayrak.nortwind.core.utilities.results.Result;
import com.dcankayrak.nortwind.entities.concretes.Product;
import com.dcankayrak.nortwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNumber,int pageSize);
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);
	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> GetByProductAndCategory(String productName,int categoryId);
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
