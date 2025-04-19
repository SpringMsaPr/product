package com.example.product.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductUpdateStockDto {
    private Long productId;
    private Integer productQuantity;
}