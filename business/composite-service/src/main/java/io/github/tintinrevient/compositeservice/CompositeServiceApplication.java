package io.github.tintinrevient.compositeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import io.github.tintinrevient.compositeservice.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableEurekaClient
@SpringBootApplication
public class CompositeServiceApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(CompositeServiceApplication.class, args);
	}

}
