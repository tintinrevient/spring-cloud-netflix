package io.github.tintinrevient.recommendationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.tintinrevient.recommendationservice.model.Recommendation;
import java.util.List;

public interface RecommendationRepository  extends JpaRepository<Recommendation, Integer> {
    public List<Recommendation> findAll();
    public List<Recommendation> findByProduct(int product);
}
