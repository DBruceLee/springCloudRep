package com.dbstar.consulclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc/{id}/{name}")
    public String dc(@PathVariable String id,@PathVariable String name) {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(id+name);
        System.out.println(services);
        return services;
    }
}
