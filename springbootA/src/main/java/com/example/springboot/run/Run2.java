package com.example.springboot.run;


import com.example.springboot.util.HttpClient;

public class Run2 implements Runnable {
    @Override
    public void run() {
        HttpClient.doGet("https://www.baidu.com");
        System.out.println("又请求百度");
    }
}
