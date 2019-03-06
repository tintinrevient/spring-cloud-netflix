package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Product;
import org.springframework.hateoas.Resources;

@FeignClient("product-service")
public interface ProductClient {
    @RequestMapping(value = "/product")
    Resources<Product> getAllProducts();
}
