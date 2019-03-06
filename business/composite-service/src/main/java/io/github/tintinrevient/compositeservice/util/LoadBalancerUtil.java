package io.github.tintinrevient.compositeservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class LoadBalancerUtil {

    @Autowired
    private static LoadBalancerClient loadBalancerClient;

    public static URI getServiceUri(String serviceId, String fallbackUri) {
        URI uri = null;
        try {
            ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
            uri = serviceInstance.getUri();

        } catch (RuntimeException e) {
            // If Eureka is not available, use fallback
            uri = URI.create(fallbackUri);
        }

        return uri;
    }

    public static <T> ResponseEntity<T> createOkResponse(T body) {
        return createResponse(body, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<>(body, httpStatus);
    }
}