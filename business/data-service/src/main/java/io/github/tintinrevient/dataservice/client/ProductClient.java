package io.github.tintinrevient.dataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.tintinrevient.dataservice.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @RequestMapping(value = "/product")
    List<Product> getAllProducts();

    @RequestMapping(value = "/product/{id}")
    List<Product> getProductById(@PathVariable("id") int id);

}
