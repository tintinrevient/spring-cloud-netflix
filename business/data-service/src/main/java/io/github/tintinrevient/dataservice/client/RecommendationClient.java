package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Recommendation;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("recommendation-service")
public interface RecommendationClient {

    @RequestMapping(value = "/recommendation")
    Resources<Recommendation> getAllRecommendations();

    @RequestMapping(value = "/recommendation/search/findByProduct")
    Resources<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product);

}
