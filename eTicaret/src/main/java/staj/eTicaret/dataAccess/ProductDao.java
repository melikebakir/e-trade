package staj.eTicaret.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import staj.eTicaret.entities.concretes.Product;
import staj.eTicaret.entities.dtos.ProductWithCategoryDto;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getByProductName(String productName);
	Product getByProductNameAndCategory(String productName, String category);
	List<Product> getByProductNameOrCategory(String productName, String category);
	List<Product> getByCategoryIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName);
	//select * from products where category_id in(1,2,3,4)
	List<Product> getByProductNameStartsWith(String productName);
	//select * from products where product_name=xxx and categoryId=yyyy
	@Query("From Product where productName=:productName and category=:category")
	List<Product> getByNameAndCategory(@Param("productName") String productName, @Param("category") String category);
	//kategori ile kategoriyle ilşkilendirilmiş productlardan çek
	@Query("Select new staj.eTicaret.entities.dtos.ProductWithCategoryDto(p.id, p.productName, p.category) From Product p ")
	List<Product> getProductWithCategoryDetails();
	

}
