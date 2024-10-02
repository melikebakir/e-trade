package staj.eTicaret.businness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import staj.eTicaret.entities.concretes.Category;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    private String productName;

    private double unitPrice;

    private short unitsInStock;

    private String quantityPerUnit;

    private Category category;
}
