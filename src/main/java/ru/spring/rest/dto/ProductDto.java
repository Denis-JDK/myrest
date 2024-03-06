package ru.spring.rest.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spring.rest.entity.Product;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductDto {

    private Long id;

    private String name;

    private BigDecimal price;

    public ProductDto (Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
