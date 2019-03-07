package io.github.tintinrevient.recommendationservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.recommendationservice.model.Recommendation;
import io.github.tintinrevient.recommendationservice.dao.RecommendationRepository;
import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @RequestMapping(value = "/recommendation")
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @RequestMapping(value = "/recommendation/search/findByProduct")
    public List<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product) {
        return recommendationRepository.findByProduct(product);
    }
}