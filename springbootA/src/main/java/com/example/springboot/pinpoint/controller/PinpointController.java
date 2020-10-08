package com.example.springboot.pinpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.util.*;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "/pinpoint")
public class PinpointController {
    @GetMapping("/hello")
    public String index(){
        return "hello";
    }

    @GetMapping("/async")
    public String async(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                HttpClient.doGet("https://www.baidu.com");
                System.out.println("请求百度");

            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                HttpClient.doGet("https://www.baidu.com");
                System.out.println("又请求百度");
            }
        };
        executor.execute(run1);
        executor.execute(run2);

        return "async";
    }
}
