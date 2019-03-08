# spring-cloud-netflix

This is a skeleton template built based on Spring Cloud Netflix - https://spring.io/projects/spring-cloud-netflix

The technical stack is as below:
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/mapping-table.png)

The sample code is structured as below:
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/system-landscape.png)

Hystrix is added into the landscape to ensure the resilience of the system and prevent the errors from propagating to the whole network by the introduction of the fallback methods. To monitor the metrics, Hystrix dashboard is wired by means of RabbitMQ. To test the circuit breaker functionalities of Hystrix, we can put all the product-service instances offline and send requests to the Zuul proxy by the tool Apache Benchmarking - https://httpd.apache.org/docs/2.4/programs/ab.html with the command as below (e.g. The number of requests is 30 with 5 concurrent requests):

```
user:~ admin$ ab -n 30 -c 5 http://localhost:8765/data/product
```

The Hystrix dashboard is as below with every @HystrixCommand being monitored and the stream pushed to RabbitMQ.
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/hystrix-dashboard.png)
