package io.github.tintinrevient.productservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.tintinrevient.productservice.dao.ProductRepository;
import io.github.tintinrevient.productservice.model.Product;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping(value = "/products")
    public List<Product> getProducts() {

        List<Product> productList = productRepository.findAll();
        return productList;
    }

}
