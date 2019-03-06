package io.github.tintinrevient.compositeservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.compositeservice.model.Product;
import io.github.tintinrevient.compositeservice.service.DataService;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
public class CompositeController {

    @Autowired
    private DataService dataService;


    @RequestMapping(
            value="/product/{productId}"
//            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return dataService.getProduct(productId);
    }
}