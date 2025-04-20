package com.example.product.product.dto;

import com.example.product.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegisterDto {

    private String name;
    private String category;
    private int price;
    private int stockQuantity;

    public Product toEntity(Long userId, String name, String category, int price, int stockQuantity){
        return Product.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .memberId(userId)
                .build();
    }
}
