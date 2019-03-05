package io.github.tintinrevient.reviewservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.github.tintinrevient.reviewservice.model.Review;

@RepositoryRestResource
public interface ReviewRepository  extends JpaRepository<Review, Long> {
}
