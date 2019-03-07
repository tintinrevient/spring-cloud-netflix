package io.github.tintinrevient.dataservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Product;
import io.github.tintinrevient.dataservice.model.Recommendation;
import io.github.tintinrevient.dataservice.model.Review;
import io.github.tintinrevient.dataservice.client.ProductClient;
import io.github.tintinrevient.dataservice.client.RecommendationClient;
import io.github.tintinrevient.dataservice.client.ReviewClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import java.util.ArrayList;

@RestController
@Component
public class DataController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RecommendationClient recommendationClient;

    @Autowired
    private ReviewClient reviewClient;


    @RequestMapping(value = "/product")
    @HystrixCommand(fallbackMethod = "getDefaultProducts")
    public List<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    @RequestMapping(value = "/product/{id}")
    @HystrixCommand(fallbackMethod = "getDefaultProducts")
    public List<Product> getProductById(@PathVariable("id") int id) {
        return productClient.getProductById(id);
    }

    public List<Product> getDefaultProducts() {
        return new ArrayList<Product>();
    }

    public List<Product> getDefaultProducts(int id) {
        return new ArrayList<Product>();
    }


    @RequestMapping(value = "/recommendation")
    @HystrixCommand(fallbackMethod = "getDefaultRecommendations")
    public List<Recommendation> getAllRecommendations() {
        return recommendationClient.getAllRecommendations();
    }

    @RequestMapping(value = "/recommendation/findByProduct")
    @HystrixCommand(fallbackMethod = "getDefaultRecommendations")
    public List<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product) {
        return recommendationClient.getRecommendationsByProduct(product);
    }

    public List<Recommendation> getDefaultRecommendations() {
        return new ArrayList<Recommendation>();
    }

    public List<Recommendation> getDefaultRecommendations(int product) {
        return new ArrayList<Recommendation>();
    }


    @RequestMapping(value = "/review")
    @HystrixCommand(fallbackMethod = "getDefaultReviews")
    public List<Review> getAllReviews() {
        return reviewClient.getAllReviews();
    }

    @RequestMapping(value = "/review/findByProduct")
    @HystrixCommand(fallbackMethod = "getDefaultReviews")
    public List<Review> getReviewsByProduct(@RequestParam("product") int product) {
        return reviewClient.getReviewsByProduct(product);
    }

    public List<Review> getDefaultReviews() {
        return new ArrayList<Review>();
    }

    public List<Review> getDefaultReviews(int product) {
        return new ArrayList<Review>();
    }

}