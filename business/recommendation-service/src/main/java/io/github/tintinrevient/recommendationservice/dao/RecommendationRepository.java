package io.github.tintinrevient.recommendationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.github.tintinrevient.recommendationservice.model.Recommendation;

@RepositoryRestResource
public interface RecommendationRepository  extends JpaRepository<Recommendation, Long> {
}
