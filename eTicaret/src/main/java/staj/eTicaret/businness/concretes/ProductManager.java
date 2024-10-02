package staj.eTicaret.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import staj.eTicaret.businness.abstracts.ProductService;
import staj.eTicaret.businness.requests.CreateProductRequest;
import staj.eTicaret.businness.requests.UpdateProductRequest;
import staj.eTicaret.core.mappers.ModelMapperService;
import staj.eTicaret.core.utilities.DataResult;
import staj.eTicaret.core.utilities.Result;
import staj.eTicaret.core.utilities.SuccessDataResult;
import staj.eTicaret.core.utilities.SuccessResult;
import staj.eTicaret.dataAccess.ProductDao;
import staj.eTicaret.entities.concretes.Product;
import staj.eTicaret.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	private ModelMapperService modelMapperService;


	public ProductManager(ProductDao productDao, ModelMapperService modelMapperService) {
		this.productDao = productDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<Product>> getAll() {
	    
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Data listelendi");			
			
		}

	/*@Override
	public Result add(ProductRequest request) {
		Product product1= new Product();
		product1.setProductName(request.getProductName());
		product1.setCategory(request.getCategory());
		product1.setUnitPrice(request.getUnitPrice());
		product1.setUnitsInStock(request.getUnitsInStock());
		product1.setQuantityPerUnit(request.getQuantityPerUnit());
		this.productDao.save(product1);
		return new SuccessResult("Ürün eklendi");
	}*/
	@Override
	public Result add(CreateProductRequest createProductRequest){
		Product product1 = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
		this.productDao.save(product1);
        return new SuccessResult("Ürün eklendi");
    }
	@Override
	public Result update(UpdateProductRequest updateProductRequest){
		Product product1=this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
		this.productDao.save(product1);
		return new SuccessResult("Ürün güncellendi");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, String category) {
		//businness codes
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory(productName, category), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, String category) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory(productName, category), "Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories), "Data Listelendi");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); 
		
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "ProductName");
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(sort),"Listelendi");
	}


	@Override
	public DataResult<List<Product>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getProductWithCategoryDetails(), "Data listelendi");
		
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, String category) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, category), "Data Listelendi");
	}

}
