package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    NeoProperties n;
    @RequestMapping("/hello")
    public String index(){
        System.out.println("hello world");


        return "hello world"+n.getDescription()+n.getTitle();
    }
}
