package com.greenlearner.product.controller;

import com.greenlearner.product.dto.Product;
import com.greenlearner.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    ResponseEntity<Product> addProduct(@RequestBody Product product){

        String status = productService.addProduct(product);
        logger.info("Prouct added status - {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    List<Product> productList() {
        return productService.listAllProducts();
    }

    @GetMapping("/productCategoryList")
    List<Product> productCategoryList(@PathVariable String category) {
        return productService.listAllProducts(category);
    }

    @GetMapping("/product/{id}")
    Product productById(@PathVariable Integer id) {
        return productService.productById(id);
    }
}
