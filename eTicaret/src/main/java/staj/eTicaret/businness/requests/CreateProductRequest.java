package staj.eTicaret.businness.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import staj.eTicaret.entities.concretes.Category;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @JsonIgnore
    private int id;

    private String productName;

    private double unitPrice;

    private short unitsInStock;

    private String quantityPerUnit;

    private String category;
}
