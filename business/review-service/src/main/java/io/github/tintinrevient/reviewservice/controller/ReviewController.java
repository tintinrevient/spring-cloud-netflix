package io.github.tintinrevient.reviewservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.reviewservice.model.Review;
import io.github.tintinrevient.reviewservice.dao.ReviewRepository;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(value = "/review")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @RequestMapping(value = "/review/search/findByProduct")
    public List<Review> getReviewsByProduct(@RequestParam("product") int product) {
        return reviewRepository.findByProduct(product);
    }
}