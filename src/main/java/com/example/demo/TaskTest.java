package com.example.demo;

import cn.hutool.core.date.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

/**
 * @author Zero
 */
@Component
public class TaskTest {
//    @Scheduled(fixedRate = 2000)
    @Scheduled(cron = "5 * * * * *")
    public void run(){
        System.out.println(DateTime.now());
    }
}
