package staj.eTicaret.businness.abstracts;

import java.util.List;

import staj.eTicaret.businness.requests.CreateProductRequest;
import staj.eTicaret.businness.requests.UpdateProductRequest;
import staj.eTicaret.core.utilities.DataResult;
import staj.eTicaret.core.utilities.Result;
import staj.eTicaret.entities.concretes.Product;
import staj.eTicaret.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);//sayfalama
	Result add(CreateProductRequest product);
	Result update(UpdateProductRequest product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, String category);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, String category);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName, String category);
	
	DataResult<List<Product>> getProductWithCategoryDetails();
}
