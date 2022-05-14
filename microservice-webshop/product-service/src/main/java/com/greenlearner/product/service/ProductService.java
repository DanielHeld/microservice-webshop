package com.greenlearner.product.service;

import com.greenlearner.product.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public String addProduct(Product product) {

        products.add(product);

        return "success";
    }

    public List<Product> listAllProducts() {
        return products;
    }

    public List<Product> listAllProducts(String category) {
        return products.stream()
                .filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product productById(Integer id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .get();
    }
}
