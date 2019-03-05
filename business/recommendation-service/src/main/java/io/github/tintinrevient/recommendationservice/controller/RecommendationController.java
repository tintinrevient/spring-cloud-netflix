package io.github.tintinrevient.recommendationservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.tintinrevient.recommendationservice.dao.RecommendationRepository;
import io.github.tintinrevient.recommendationservice.model.Recommendation;

import java.util.List;
import java.util.ArrayList;

@RestController
public class RecommendationController {

    private RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }


    @RequestMapping(value = "/recommendations")
    public List<Recommendation> getRecommendations() {

        List<Recommendation> recommendationList = recommendationRepository.findAll();
        return recommendationList;
    }

}
