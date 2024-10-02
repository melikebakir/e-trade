package staj.eTicaret.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import staj.eTicaret.businness.abstracts.ProductService;
import staj.eTicaret.businness.requests.CreateProductRequest;
import staj.eTicaret.core.utilities.DataResult;
import staj.eTicaret.core.utilities.Result;
import staj.eTicaret.entities.concretes.Product;
import staj.eTicaret.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductService productService;
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){

		return this.productService.getAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<Product>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
		}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateProductRequest product) {
		return this.productService.add(product);
	}

	//verilen ürün adı ile ürünü getirir.
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	// verilen ürün adı ve kategoriye göre ürünü getirir.
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> 
	getByProductNameAndCategoryId(@RequestParam String category, @RequestParam String productName){
		return this.productService.getByProductNameAndCategoryId(productName, category);
	}
	//ürün adında belirtilen kelimeyi içeren ürünleri getirir.
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> 
	getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
		
	}
	//sayfalama parametreleri ile ürünlerin bir listesini getirir.
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
	return this.productService.getAll(pageNo, pageSize);
	}
	//ürünleri azalan sıraya göre sıralanmış olarak getirir.
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
}
/*

	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest){
		this.brandService.add(createBrandRequest);

	}
	@PutMapping //güncelleme
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest ) {
		this.brandService.update(updateBrandRequest);

	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);

	}
	 */
