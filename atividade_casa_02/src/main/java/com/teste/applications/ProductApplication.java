package com.teste.applications;

import com.teste.entities.Product;
import com.teste.services.ProductService;

public class ProductApplication {
    private ProductService productService;

    public ProductApplication(ProductService productService) {
        this.productService = productService;
    }

    public void append(Product product) {
        this.productService.save(product);
    }

    public void remove(int id) {
        this.productService.remove(id);
    }

    public void update(int id, Product product) {
        this.productService.update(product);
    }
}