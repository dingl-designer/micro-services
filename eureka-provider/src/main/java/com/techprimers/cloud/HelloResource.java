package com.techprimers.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/provider")
public class HelloResource {

    @GetMapping
    public String hello(){
        System.out.println("Calling reached");
        return "Hello World!";
    }
}
