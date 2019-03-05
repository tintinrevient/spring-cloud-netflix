package io.github.tintinrevient.reviewservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.tintinrevient.reviewservice.dao.ReviewRepository;
import io.github.tintinrevient.reviewservice.model.Review;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ReviewController {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @RequestMapping(value = "/reviews")
    public List<Review> getReviews() {

        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }

}
