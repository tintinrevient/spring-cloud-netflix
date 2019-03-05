package io.github.tintinrevient.reviewservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import io.github.tintinrevient.reviewservice.model.Review;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "review", path = "review")
public interface ReviewRepository  extends JpaRepository<Review, Long> {
    List<Review> findByProduct(@Param("id") Long product);
}
