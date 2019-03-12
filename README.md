# spring-cloud-netflix

This is a skeleton template built based on Spring Cloud Netflix - https://spring.io/projects/spring-cloud-netflix

## Technical Stack

The technical stack is as below:
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/mapping-table.png)

## System Landscape

The sample code is structured as below:
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/system-landscape.png)

## Hystrix

Hystrix is added into the landscape to ensure the resilience of the system and prevent the errors from propagating to the whole network by the introduction of the fallback methods. To monitor the metrics, Hystrix dashboard is wired by means of RabbitMQ. To test the circuit breaker functionalities of Hystrix, we can put all the product-service instances offline and send requests to the Zuul proxy by the tool Apache Benchmarking - https://httpd.apache.org/docs/2.4/programs/ab.html with the command as below (e.g. The number of requests is 30 with 5 concurrent requests):

```
user:~ admin$ ab -n 30 -c 5 http://127.0.0.1:8765/data/product
```

The Hystrix dashboard is as below with every @HystrixCommand being monitored and the stream pushed to RabbitMQ.
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/hystrix-dashboard.png)

## OAuth2

The OAuth 2.0 specification defines four grant flows to obtain an access token:
![alt text](https://github.com/tintinrevient/spring-cloud-netflix/blob/master/grant-flows.png)

In the sample code, we uses Resource Owner Password Credentials and to obtain an access token, execute the cURL command below:

```
user:~ admin$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=user

{
    "access_token": "28f86c86-3abf-451c-b167-45a942f9943d",
    "token_type": "bearer",
    "expires_in": 1954,
    "scope": "read write"
}
```
With the access token, execute the cURL command below to request the protected resources:

```
user:~ admin$ curl 'http://localhost:8080/product' -H 'Authorization: Bearer 28f86c86-3abf-451c-b167-45a942f9943d' | jq .

[
    {
        "id": 1,
        "name": "book",
        "description": "MySQL in Action"
    },
    {
        "id": 2,
        "name": "clothes",
        "description": "Zara"
    },
    {
        "id": 3,
        "name": "book",
        "description": "Historian"
    }
]
```

