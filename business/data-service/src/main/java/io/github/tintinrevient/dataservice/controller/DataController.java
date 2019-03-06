package io.github.tintinrevient.dataservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.dataservice.model.Product;
import io.github.tintinrevient.dataservice.model.Recommendation;
import io.github.tintinrevient.dataservice.model.Review;
import io.github.tintinrevient.dataservice.client.ProductClient;
import io.github.tintinrevient.dataservice.client.RecommendationClient;
import io.github.tintinrevient.dataservice.client.ReviewClient;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DataController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RecommendationClient recommendationClient;

    @Autowired
    private ReviewClient reviewClient;


    @RequestMapping(
            value="/product",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Product> getAllProducts() {
        return productClient.getAllProducts();
    }


    @RequestMapping(
            value="/product/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resource<Product> getOneProduct(@PathVariable("id") int id) {
        return productClient.getProductById(id);
    }


    @RequestMapping(
            value="/recommendation",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Recommendation> getAllRecommendations() {
        return recommendationClient.getAllRecommendations();
    }


    @RequestMapping(
            value="/recommendation/findByProduct",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product) {
        return recommendationClient.getRecommendationsByProduct(product);
    }

    @RequestMapping(
            value="/review",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Review> getAllReviews() {
        return reviewClient.getAllReviews();
    }


    @RequestMapping(
            value="/review/findByProduct",
            produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"}
    )
    public Resources<Review> getReviewsByProduct(@RequestParam("product") int product) {
        return reviewClient.getReviewsByProduct(product);
    }
}