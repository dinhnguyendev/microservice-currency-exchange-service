package com.dinhnguyendev.microservice.currencyexchangeservice.controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name="sample-api", fallbackMethod = "handleFallback" )

    // Cách này sử dụng khi call api failed hay gì đó mình dùng CircuitBreaker để response về mà không cần throw exception
//    @CircuitBreaker(name = "default",fallbackMethod = "handleFallback")
//    @Bulkhead()
    public String sampleApi(){

        logger.info("Sample API request call api :)");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://locahost:8080/test",String.class);
        return response.getBody();
    }

    public String handleFallback(Exception e){

        return "fallback-handler-response";
    }
}
