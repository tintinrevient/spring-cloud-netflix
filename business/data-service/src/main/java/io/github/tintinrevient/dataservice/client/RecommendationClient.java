package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Recommendation;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient("recommendation-service")
public interface RecommendationClient {

    @RequestMapping(value = "/recommendation")
    List<Recommendation> getAllRecommendations();

    @RequestMapping(value = "/recommendation/search/findByProduct")
    List<Recommendation> getRecommendationsByProduct(@RequestParam("product") int product);

}
