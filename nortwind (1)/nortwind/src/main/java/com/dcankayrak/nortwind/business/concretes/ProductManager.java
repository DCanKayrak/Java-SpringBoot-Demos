package com.dcankayrak.nortwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dcankayrak.nortwind.business.abstracts.ProductService;
import com.dcankayrak.nortwind.core.utilities.results.DataResult;
import com.dcankayrak.nortwind.core.utilities.results.Result;
import com.dcankayrak.nortwind.core.utilities.results.SuccessDataResult;
import com.dcankayrak.nortwind.core.utilities.results.SuccessResult;
import com.dcankayrak.nortwind.dataAccess.abstracts.ProductDAO;
import com.dcankayrak.nortwind.entities.concretes.Product;
import com.dcankayrak.nortwind.entities.dtos.ProductWithCategoryDto;

@Service // business
public class ProductManager implements ProductService{
	private ProductDAO productDao;
	
	@Autowired
	public ProductManager(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	
	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(),"Data Listelendi!");
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi!");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi!");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName,categoryId),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory(productName, categoryId),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> GetByProductAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.GetByProductAndCategory(productName, categoryId),"Data Listelendi!");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
	}


	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails());
	}
	
	
	
	
}
