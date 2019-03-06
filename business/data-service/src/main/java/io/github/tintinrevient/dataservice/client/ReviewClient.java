package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Review;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("review-service")
public interface ReviewClient {

    @RequestMapping(value = "/review")
    Resources<Review> getAllReviews();

    @RequestMapping(value = "/review/search/findByProduct")
    Resources<Review> getReviewsByProduct(@RequestParam("product") int product);

}
