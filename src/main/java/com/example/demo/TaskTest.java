package com.example.demo;

import cn.hutool.core.date.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskTest {
    @Scheduled(fixedRate = 2000)
    public void run(){
        System.out.println(DateTime.now());
    }
}
