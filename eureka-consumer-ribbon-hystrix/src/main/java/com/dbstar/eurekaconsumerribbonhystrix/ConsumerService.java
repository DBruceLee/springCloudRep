package com.dbstar.eurekaconsumerribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(String consumer) {
        String url = "http://eureka-client/dc/" + consumer;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(String consumer) {
        return "fallback : "+consumer;
    }
}
