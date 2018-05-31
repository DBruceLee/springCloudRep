package com.dbstar.eurekaconsumerfeign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc/eureka-consumer-feign")
    String consumer();

    @GetMapping("/consume")
    String consume(@RequestParam("name") String name);
}
