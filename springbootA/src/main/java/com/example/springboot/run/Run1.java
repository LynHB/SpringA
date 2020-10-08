package com.example.springboot.run;


import com.example.springboot.util.HttpClient;

public class Run1 implements Runnable {
    @Override
    public void run() {
        HttpClient.doGet("https://www.baidu.com");
        System.out.println("请求百度");
    }
}
