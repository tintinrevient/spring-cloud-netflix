package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Review;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient("review-service")
public interface ReviewClient {

    @RequestMapping(value = "/review")
    List<Review> getAllReviews();

    @RequestMapping(value = "/review/search/findByProduct")
    List<Review> getReviewsByProduct(@RequestParam("product") int product);

}
