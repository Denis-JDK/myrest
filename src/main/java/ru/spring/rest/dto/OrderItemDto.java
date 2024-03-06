package ru.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDto {

    private Long productId;
    private BigDecimal productPrice;
    private Integer quantity;
}
