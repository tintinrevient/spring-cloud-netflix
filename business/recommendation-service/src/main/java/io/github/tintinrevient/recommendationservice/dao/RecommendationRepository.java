package io.github.tintinrevient.recommendationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import io.github.tintinrevient.recommendationservice.model.Recommendation;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recommendation", path = "recommendation")
public interface RecommendationRepository  extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByProduct(@Param("id") Long product);
}
