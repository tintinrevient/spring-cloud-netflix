package io.github.tintinrevient.dataservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.dataservice.model.Product;
import io.github.tintinrevient.dataservice.client.ProductClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

@RestController
public class DataController {

    @Autowired
    private ProductClient productClient;


    @RequestMapping(
            value="/product",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Product> getAllProducts() {
        return productClient.getAllProducts();
    }
}