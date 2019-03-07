package io.github.tintinrevient.reviewservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.tintinrevient.reviewservice.model.Review;
import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Integer> {
    public List<Review> findAll();
    public List<Review> findByProduct(int product);
}
