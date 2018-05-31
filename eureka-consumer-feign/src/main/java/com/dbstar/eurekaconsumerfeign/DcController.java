package com.dbstar.eurekaconsumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @GetMapping("/find")
    public String consume(@RequestParam(defaultValue = "dbstar") String name) {
        return dcClient.consume(name);
    }
}
