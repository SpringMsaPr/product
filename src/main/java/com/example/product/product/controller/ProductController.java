package com.example.product.product.controller;

import com.example.product.product.domain.Product;
import com.example.product.product.dto.ProductRegisterDto;
import com.example.product.product.dto.ProductResDto;
import com.example.product.product.dto.ProductUpdateStockDto;
import com.example.product.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> productCreate(ProductRegisterDto dto, @RequestHeader("X-User-Id") String userId) {
        Product product = productService.productCreate(dto, userId);
        return new ResponseEntity<>(product.getId(), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> productDetail(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) throws InterruptedException {
        Thread.sleep(3000L);
        ProductResDto productResDto = productService.productDetail(id);
        return new ResponseEntity<>(productResDto, HttpStatus.OK);
    }

    @PutMapping("/updatestock")
    public ResponseEntity<?> updateStock(@RequestBody ProductUpdateStockDto productUpdateStockDto) {

        Product product = productService.updateStockQuantity(productUpdateStockDto);

        return new ResponseEntity<>(product.getId(), HttpStatus.OK);
    }
}