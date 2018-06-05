package com.dbstar.eurekaconsumerribbonhystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {


    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc(@RequestParam(defaultValue = "consumer-ribbon-hystrix") String consumer) {

       return consumerService.consumer(consumer);
    }
}