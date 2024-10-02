package staj.eTicaret.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductWithCategoryDto {
	private int id;
	private String productName;
	private String categoryName;

}
