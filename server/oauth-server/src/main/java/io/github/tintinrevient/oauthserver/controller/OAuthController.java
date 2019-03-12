package io.github.tintinrevient.oauthserver.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import io.github.tintinrevient.oauthserver.model.Product;
import io.github.tintinrevient.oauthserver.model.Recommendation;
import io.github.tintinrevient.oauthserver.model.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@Component
public class OAuthController {

    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/product")
    public List<Product> getAllProducts() {
        logger.info("oauth service is called.");

        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://data-service/product", Product[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(value = "/product/{id}")
    public List<Product> getProductById(@PathVariable("id") int id) {
        logger.info("oauth service is called.");

        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://data-service/product/"+id, Product[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(value = "/recommendation")
    public List<Recommendation> getAllRecommendations() {
        logger.info("oauth service is called.");

        ResponseEntity<Recommendation[]> response = restTemplate.getForEntity("http://data-service/recommendation", Recommendation[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(value = "/recommendation/findByProduct")
    public List<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product) {
        logger.info("oauth service is called.");

        ResponseEntity<Recommendation[]> response = restTemplate.getForEntity("http://data-service/recommendation/findByProduct?product="+product, Recommendation[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(value = "/review")
    public List<Review> getAllReviews() {
        logger.info("oauth service is called.");

        ResponseEntity<Review[]> response = restTemplate.getForEntity("http://data-service/review", Review[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(value = "/review/findByProduct")
    public List<Review> getReviewsByProduct(@RequestParam("product") int product) {
        logger.info("oauth service is called.");

        ResponseEntity<Review[]> response = restTemplate.getForEntity("http://data-service/review/findByProduct?product="+product, Review[].class);
        return Arrays.asList(response.getBody());
    }
}