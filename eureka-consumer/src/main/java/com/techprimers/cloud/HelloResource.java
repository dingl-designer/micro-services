package com.techprimers.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/consumer")
public class HelloResource {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(){
        System.out.println("Before calling the service");
        String url = "http://eureka-provider/rest/hello/provider";
        return restTemplate.getForObject(url, String.class);
    }

}
