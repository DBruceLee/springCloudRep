package com.dbstar.eurekaconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc(@RequestParam(defaultValue = "consumer-ribbon") String consumer) {

        String url = "http://eureka-client/dc/" + consumer;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}