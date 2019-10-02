package com.techprimers.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "hello",
        commandKey = "hello", threadPoolKey = "helloThread")

    @GetMapping
    public String hello(){
        System.out.println("Before calling the service");
        String url = "http://eureka-provider/rest/hello/provider";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(Throwable hystrixCommand){
        return "Fall back hello world!";
    }

}
