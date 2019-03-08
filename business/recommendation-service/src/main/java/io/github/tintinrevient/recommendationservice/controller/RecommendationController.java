package io.github.tintinrevient.recommendationservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.tintinrevient.recommendationservice.model.Recommendation;
import io.github.tintinrevient.recommendationservice.dao.RecommendationRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

@RestController
public class RecommendationController {

    private static final Logger logger = LoggerFactory.getLogger(RecommendationController.class);

    @Autowired
    private RecommendationRepository recommendationRepository;

    @RequestMapping(value = "/recommendation")
    public List<Recommendation> getAllRecommendations() {
        logger.info("recommendation service is called.");
        return recommendationRepository.findAll();
    }

    @RequestMapping(value = "/recommendation/search/findByProduct")
    public List<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product) {
        logger.info("recommendation service is called.");
        return recommendationRepository.findByProduct(product);
    }
}