package io.github.tintinrevient.turbineserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableTurbineStream
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class TurbineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineServerApplication.class, args);
	}

}
