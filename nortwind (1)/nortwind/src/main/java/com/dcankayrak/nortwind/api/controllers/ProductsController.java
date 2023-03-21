package com.dcankayrak.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcankayrak.nortwind.business.abstracts.ProductService;
import com.dcankayrak.nortwind.core.utilities.results.DataResult;
import com.dcankayrak.nortwind.core.utilities.results.Result;
import com.dcankayrak.nortwind.entities.concretes.Product;
import com.dcankayrak.nortwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory(productName, categoryId);
	}
	
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories){
		return this.productService.getByCategoryIn(categories);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	public DataResult<List<Product>> GetByProductAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.GetByProductAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNumber,int pageSize){
		return this.productService.getAll(pageNumber, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithDetails")
	public DataResult<List<ProductWithCategoryDto>> getDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
}
