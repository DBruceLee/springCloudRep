package com.dbstar.eurekaconsumerribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * @Description: 服务降级
     * @Param: [consumer]
     * @return: java.lang.String
     * @Author: dbstar
     * @Date: 2018/6/5 下午3:14
     **/
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(String consumer) {
        String url = "http://eureka-client/dc/" + consumer;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(String consumer) {
        return "fallback : " + consumer;
    }
}
