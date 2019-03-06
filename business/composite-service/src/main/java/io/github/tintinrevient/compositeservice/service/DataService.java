package io.github.tintinrevient.compositeservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import io.github.tintinrevient.compositeservice.model.Product;
import io.github.tintinrevient.compositeservice.util.LoadBalancerUtil;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Component
public class DataService {

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<Product> getProduct(Long productId) {
        URI uri = LoadBalancerUtil.getServiceUri("product-service", "http://localhost:8081");
        String url = uri.toString() + "/product/" + productId;

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        Product product = response2Product(resultStr);

        return LoadBalancerUtil.createOkResponse(product);
    }

    private Product response2Product(ResponseEntity<String> response) {
        try {
            return getProductReader().readValue(response.getBody());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectReader productReader = null;

    private ObjectReader getProductReader() {
        if (productReader != null) return productReader;

        ObjectMapper mapper = new ObjectMapper();
        return productReader = mapper.reader(Product.class);
    }
}